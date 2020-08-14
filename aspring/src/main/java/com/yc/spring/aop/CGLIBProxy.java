package com.yc.spring.aop;

import java.lang.reflect.Method;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

public class CGLIBProxy  implements MethodInterceptor{
	
	
	public static void main(String[] args) {
		//创建被代理对象
		RealSubject rs=new RealSubject();
		Houseowner ho=new Houseowner();
		//创建代理对象，调用方法
		CGLIBProxy cp=new CGLIBProxy();
		
		RealSubject proxyrs=(RealSubject) cp.proxy(rs);
		proxyrs.say();
		
		Houseowner proxyho=(Houseowner) cp.proxy(ho);
		proxyho.sale();
		
		
		
	}
	//被代理主题
	private Object realSubject;
	
	
	/*1:obj 目标对象代理的实例
	 * 2： method 代理实例上调用父类的method方法实例
	 * 3：args  传入到代理实例上方法参数值的对象数组
	 * 4：methodProxy 使用它调用父类的方法
	 * 
	 * */
	public Object intercept(Object obj, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
		
		System.out.println("代理类"+obj.getClass());
		System.out.println("代理方法"+method.getName());
		if(args !=null && args.length>0) {
			for(int i=0;i<args.length;i++) {
				System.out.println("方法参数："+args[i]);
			}
		}
		Object returnvalue=null;//方法返回值，无返回类型时为null
		returnvalue =methodProxy.invoke(this.realSubject, args);//调用目标对象的方法
        System.out.println("方法的返回值:"+returnvalue);
        return returnvalue;
		

		// TODO Auto-generated method stub
	}
	//代理方法
	public Object proxy(Object targetObuject) {
		this.realSubject=targetObuject;
		
		Enhancer enhancer=new  Enhancer(); //该类用来生成代理对象
		enhancer.setSuperclass(targetObuject.getClass());//设置父类的类对象也就是目标对象，真实真实主题
		enhancer.setCallback(this);//设置回调的对象本身。目标对象方法执行时同时调用
		return enhancer.create();//创建代理对象，返回被代理对象的方法
	}

}
