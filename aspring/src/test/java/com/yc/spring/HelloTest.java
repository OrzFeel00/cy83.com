package com.yc.spring;


import static org.junit.Assert.assertArrayEquals;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.yc.spring.bean.Person;
import com.yc.spring.dao.UserDao;


public class HelloTest {
	private 	ClassPathXmlApplicationContext ctx;
	@Before
	public void before() {
		ctx=new ClassPathXmlApplicationContext("beans.xml");
	}
	@Before
	public void closs() {
		ctx=new ClassPathXmlApplicationContext("beans.xml");
	}
	
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
	 
	 @Test
		public void test3() {
			
			Person p1=(Person) ctx.getBean("p1");
			
			Assert.assertEquals("武松", p1.getName());
			Assert.assertEquals(35, p1.getAge());
			Assert.assertEquals(3, p1.getKilleds().size());
			Assert.assertEquals("潘金莲", p1.getKilleds().get(2));
			
		
			System.out.println("姓名:"+p1.getName()+"\n年龄:"+p1.getAge()+"岁\n身高:"+p1.getHeight()+
					"cm\n体重:"+p1.getWeight()+"\n战绩:"+p1.getKilleds());
			ctx.close();
		}
	 
	 
	 @Test
		public void test4() {
			
			Person p1=ctx.getBean(Person.class);
			
			Assert.assertEquals("李逵", p1.getName());
			Assert.assertEquals(40, p1.getAge());
			Assert.assertEquals(null, p1.getKilleds());
		//	Assert.assertEquals(0, p1.getKilleds().size());
		
			
		
			System.out.println("姓名:"+p1.getName()+"\n年龄:"+p1.getAge()+"岁\n身高:"+p1.getHeight()+
					"cm\n体重:"+p1.getWeight()+"\n战绩:"+p1.getKilleds());
			ctx.close();
		}
	 
	 @Test
		public void test5() {
			
			Person p1=(Person) ctx.getBean("p2");
			
			Assert.assertEquals("吴用", p1.getName());
			Assert.assertEquals(44, p1.getAge());
		
		//	Assert.assertEquals(0, p1.getKilleds().size());
		
			
		
			ctx.close();
		}
	 @Test
		public void test6() {
			
			Person p1=(Person) ctx.getBean("p5");
			
			Assert.assertEquals("王英", p1.getName());
			Assert.assertEquals(150, p1.getHeight());
		
		
			ctx.close();
		}
	 
	 
	 
	 @Test
		public void test8() {
			Hello h0=(Hello) ctx.getBean("hello3");
			
		
		
			ctx.close();
		}
	 
	 @Test
		public void test9() {
		 Person p7=(Person) ctx.getBean("p7");
			
		System.out.println(p7.getFriend().getName());
		
			ctx.close();
		}
	 

}
