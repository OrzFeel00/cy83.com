package com.yc.spring.aop;
/*
 * mybits 的会话对象
 * */

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import org.apache.ibatis.annotations.Insert;

import com.yc.spring.bean.Person;
import com.yc.spring.dao.UserDao;

public class Sqlsession {
	public static void main(String[] args) {
		
		Sqlsession session=new Sqlsession();
	UserDao udao=	session.getMapper(UserDao.class);
		udao.insert(new Person());
		
	}
	/*
	 * 根据输入的接口，返回接口代理对象
	 * mybits的动态代理没有目标对象
	 * */
	//泛型方法,输入什么类型，返回就是什么类型对象
	public<M> M getMapper(Class<M> cls) {
		
		@SuppressWarnings("unchecked")
		M ret=(M) Proxy.newProxyInstance(cls.getClassLoader(), new Class[] {cls}, new InvocationHandler() {
			
			public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
			Insert insert=	method.getAnnotation(Insert.class);
			if(insert!=null) {
				//使用dbhelp 执行该语句
				System.out.println("执行："+insert.value()[0]);
				//更具方法的返回结果，将dbhelp的执行结果返回
				if(method.getReturnType()!=null) {
					if(method.getReturnType().equals(int.class)) {
						//如果返回值类型是integer就返回integer
						return 0;
					}
					
				}
				
			}
				return null;
			}
		});
		
		return ret;
		
	}
	

}
