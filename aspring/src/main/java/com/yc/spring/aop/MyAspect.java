package com.yc.spring.aop;

import org.aopalliance.intercept.Joinpoint;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyAspect {
	//aspcrtj的切点表达式
	//execution 定义要拦截方法的描述
	//execution( public void 包名。类名。方法名（参数）)
	@Pointcut(("execution( * com.yc.spring.dao.*Dao.select*(..))"))
	public void aspect1() {
		//切点方法
	}
	
	/*
	 * try{
	 * before();//前置增强（业务方法之前执行)
	 * biz();
	 * }catch(exception e){
	 * afterThrowing(//异常增强
	 *
	 * }
	 * finally{
	 * after()/后置增强
	 * }
	 *  afterReturning()//返回增强
	 *====1====
=====前置增强（业务方法之前执行)=====
oracle user dao
====后置增强===
====返回增强===
====2====
=====前置增强（业务方法之前执行)=====
mysql user dao
====后置增强===
====异常增强===
	 * 
	 * */
	//Joinpoint 连接点对象===》就是就是表示的一个方法，，底层封装java反射对象
	//这里就是一个接口注入Joinpoint对象，由spring帮我我们注入
	@Before("aspect1()")//before是aspect里的，，不是junte里的
	public void before(JoinPoint jp) {
		jp.getArgs();//方法参数
		jp.getSignature();//方法签名
		
		System.out.println("=====前置增强（业务方法之前执行)=====");
		
	}
	@After("aspect1()")
	public void after() {
		System.out.println("====后置增强===");
	}
	
	@AfterReturning(value="aspect1()",returning = "ret")//returning表示标记当前增强方法里面有一个参数用于业务方法的返回值returning
	public void AfterReturning(JoinPoint jp,Object ret) {
		
		
		System.out.println("====返回增强==返回="+ret+"=====");
	}
	@AfterThrowing(value = "aspect1()",throwing = "e")//表示业务方法产生的异常要注入到底方法参数名称throwing
	public void AfterThrowing(JoinPoint jp,Exception e) {
		System.out.println("====异常增强==="+e.getMessage()+"=异常==");
	}
	//环绕增强,业务方法需要我们自己执行，而其他4个由spring自动执行
	@Around("execution( * com.yc.spring.dao.Oracle*.select*(..))")
	public Object around(ProceedingJoinPoint pjp) {
		Object ret = null;
		try {
			//调用业务方法。。。使用场景 ：性能监控，事务管理
			long begin=System.currentTimeMillis();
			 ret=pjp.proceed();
			 long end=System.currentTimeMillis();
			 System.out.println("一共消耗量"+((end-begin)/1000)+"秒");
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return ret;
	}
	@After("execution( * com.yc.spring.Hello.*(..))")
	public void afterForHello() {
		System.out.println("====Hello的后置增强===");
	}
	
	

}
