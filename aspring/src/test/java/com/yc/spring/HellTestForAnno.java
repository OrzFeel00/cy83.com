package com.yc.spring;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.yc.spring.bean.Person;
import com.yc.spring.BeanConfig;
import com.yc.spring.dao.UserDao;


public class HellTestForAnno {

	private 	AnnotationConfigApplicationContext ctx;
	@Before
	public void before() {
		ctx=new AnnotationConfigApplicationContext(BeanConfig.class);
	}
	@After
	public void after() {
		ctx.close();
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
			public void test7() {
				Hello h0=(Hello) ctx.getBean("hello");
				Hello h0_1=(Hello) ctx.getBean("hello");
				Hello h0_2=(Hello) ctx.getBean("hello");
				
				Hello h1=(Hello) ctx.getBean("hello1");
				Hello h1_1=(Hello) ctx.getBean("hello1");
				Hello h1_2=(Hello) ctx.getBean("hello1");
				
			System.out.println(h0==h1);//f
			System.out.println(h0_1==h0_2);//t
			System.out.println(h0_1==h1_2);//f
			System.out.println(h1==h1_1);//f
			System.out.println(h1==h1_2);//f
	      	
			}
		 
		 
		 @Test
			public void test8() {
			 System.out.println("======8=====");
				Hello h0=(Hello) ctx.getBean("hello2");
				h0.sayHello();
			
			
				ctx.close();
			}
		 
		 @Test
			public void test9() {
			 Person p7=(Person) ctx.getBean("p7");
				
			System.out.println(p7.getFriend().getName());
			
				ctx.close();
			}
		 

	}
