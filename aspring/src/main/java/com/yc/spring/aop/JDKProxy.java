package com.yc.spring.aop;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

//jdk动态代理
//Porxy invorcationHander
public class JDKProxy implements InvocationHandler{
	
	public static void main(String[] args) {
		//创建动态代理对象
		JDKProxy jp=new JDKProxy();
		//真实主题
		RealSubject rs=new RealSubject();
		//代理对象的创建，并且传入rs
		//对应Subject ps=new ProxySubject();
		//是以一个接口的形式接受这个对象
		//rs这个被我传进去的对象可以是任意对象
		Subject ps=(Subject) jp.createProxyInstance(rs);
		ps.say();
		
		//真实主题
		Houseowner ho=new Houseowner();
		//传入对象
		Broker bk=(Broker) jp.createProxyInstance(ho);
		bk.sale();
		/*
		 * //错误示范@  必须使用接口实现否则报错
		Houseowner bk1=(Houseowner) jp.createProxyInstance(ho);
		bk.sale();
		
		 * */
	}
	//被代理对象  被告
	private Object realSubject;
   //当我们的被代理对象里的对应的我监听的方法一执行，我就同时触发这个方法
	/*
	 * proxy    目标对象的代理实例
	 * method   对应在代理实例上调用接口方法的method（方法）实例
	 * args           传入到代理实例的对象参数数值
	 * return           方法的返回值
	 * /
	 */
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		//相当于前置增强
		System.out.println("我的当事人有不在场证明！");
		//1执行目标方法
		Object ret= method.invoke(realSubject, args);//相当于静态代理的rs.say();
		//相当于后置增强
		System.out.println("我的当事人有不在场证明！mei");
		// TODO Auto-generated method stub
		return ret;
	}
	//构建代理对象
	//targerObject 目标对象
	public Object createProxyInstance(Object targerObject) {
		
		this.realSubject=targerObject;
		/*
		 * return  Proxy.newProxyInstance(
				loader,
				interfaces, 
				h)
				第一：设置被代理对象的类加载器，一般采用跟目标相同的类加载器，保证类的出处一样
				第二：设置代理类实现的接口，跟目标使用相同的接口
				第三：设置回调对象 ，当代理对象的方法被调用时，会调用改参数指定的对象的invoke方法（将当前的InvocationHandler这个对象传到代理对象里去）
		 * */
		return  Proxy.newProxyInstance(
				targerObject.getClass().getClassLoader(),
				targerObject.getClass().getInterfaces(), 
				this);
	}

}

interface Broker{
	void sale();
	
}

class Houseowner implements Broker{
	
	public void sale() {
		System.out.println("房子好");
	}
}

















