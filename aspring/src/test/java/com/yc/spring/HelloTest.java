package com.yc.spring;


import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class HelloTest {
	 @Test
	public void test() {
		
		ClassPathXmlApplicationContext ctx=
				new ClassPathXmlApplicationContext("beans.xml");
		
		Hello h= (Hello)ctx.getBean("hello");
		
		
		h.sayHello();
		ctx.close();
	}

}
