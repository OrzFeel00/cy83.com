package com.yc.spring;

public class Hello {
	public void sayHello() {
		System.out.println("你好");
	}

	
	
	public void init() {
		System.out.println("===========创建");
		
	}
	public void destroy() {
		System.out.println("===========销毁");
		
	}
}
