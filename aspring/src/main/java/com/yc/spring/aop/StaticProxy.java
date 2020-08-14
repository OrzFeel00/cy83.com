package com.yc.spring.aop;
//静态代理。。缺点：必要为每一个被代理对象创建一个对象。所以有了动态代理（aop切面）
/*
 * jdk动态代理：Java官方实现动态代理的方式，基于接口实现
 * 使用java虚拟机动态的制造出一个对象，于被代理对象一模一样（通过实现相同接口）//缺点开发的时候很少使用接口但是短小的项目一般没得接口
 * CGLIB动态代理 ： 第三方实现。基于动态代码生成+继承来实现
 * 动态的生成一个类
 * class proxy extends Real{}
 * 
 * 缺点不能代理final类 或final方法，因为其不能被继承和重现
 * 
 * 
 * 
 * Spring aop 的动态代理机制
 * 1如果不配置aop spring 不会启动动态代理，底层就是直接通过new 创建对象
 * 2，如果是配置aop;
 * a,如果被代理对象有实现接口，用jdk动态代理
 * b,如果被代理对象没有实现接口，使用cglib动态代理
 * */
public class StaticProxy {
	public static void main(String[] args) {
		
		Subject ps=new ProxySubject();
		ps.say();
	}
	

}
//抽象方法
interface Subject{
	void say();
	
}

//真实主题 :被告
class RealSubject implements Subject {
	public void say() {
		System.out.println("真的不是我干的！");
		
	}
	
}
//代理主题:律师
class ProxySubject implements Subject{
	//被告
	RealSubject rs=new RealSubject();
	
	public void say() {
		System.out.println("我的当事人有不在场证明！");
		rs.say();
		System.out.println("我的当事人有不在场证明！没得胆子");
		
	}
}


