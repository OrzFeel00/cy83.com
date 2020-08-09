package com.yc.spring;


import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.yc.spring.dao.UserDao;


public class HelloTest {
	 @Test
	public void test() {
		
		ClassPathXmlApplicationContext ctx=
				new ClassPathXmlApplicationContext("beans.xml");
		
		Hello h= (Hello)ctx.getBean("hello");
		
		
		h.sayHello();
		ctx.close();
	}
	 
	 
	 @Test
		public void test2() {
			
			ClassPathXmlApplicationContext ctx=
					new ClassPathXmlApplicationContext("beans.xml");
			
			UserDao udao=(UserDao) ctx.getBean("mdao");
			UserDao udao1=(UserDao) ctx.getBean("odao");
			
			udao.selectUserId("zhangs");
			udao1.selectUserId("zhangs");
			
		
			ctx.close();
		}

}
