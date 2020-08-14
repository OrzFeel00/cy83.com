package com.yc.spring;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import com.yc.spring.bean.Person;
import com.yc.spring.dao.MySQLUserDao;
import com.yc.spring.dao.OracleUserDao;
import com.yc.spring.dao.UserDao;


@RunWith(SpringRunner.class)
@ContextConfiguration(classes = AOPConfig.class)
public class AOPTest {
	@Autowired
	@Qualifier("mdao")//指定注入的组件id（name）
	private UserDao mdao;
	@Autowired
	@Qualifier("odao")
	private UserDao odao;
	
	//@Autowired
	
	//private Person person;
	@Autowired
	
	private Hello hello;

	@Test
	public void test1() {
		System.out.println("====1====");
		odao.selectUserId("");
		System.out.println("====2====");
		
		mdao.selectUserId("");
		System.out.println("====3====");
	}
	@Test
	//如果不是拦截hell那么对象就是new hello（）出来的，
	public void test2() {
		System.out.println(mdao);//jdk &p
		System.out.println(odao);//jdk
	//	System.out.println(person);
		System.out.println(hello);//cglib  debug模式下
		
		
	}
}
