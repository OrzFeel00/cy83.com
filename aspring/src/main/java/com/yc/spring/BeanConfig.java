package com.yc.spring;


import java.util.ArrayList;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.yc.spring.Hello;
import com.yc.spring.bean.Person;

//@Configuration  //ioc容器配置类的注解 ==》beans。xml
//@ComponentScan("com.yc")//组件扫描 ,自动递归扫描//如果扫到@Configuration，也会把另一个配置类当作配置文件一起合并
public class BeanConfig {
	/*
	 * @Bean(name="odao")
	public OracleUserDao getOracleUserDao() {
		return new OracleUserDao();
	}
	@Bean(name="mdao")
	public MySQLUserDao getMySQLUserDao() {
		return new MySQLUserDao();
	}
	 * 
	 * */
	
	@Bean(name="hello")
	public Hello getHello() {
		return new Hello();
	}
	@Bean(name="p1")
	public Person getPerson() {
		Person ret=new Person();
		ret.setName("武松");
		ret.setAge(35);
		ret.setKilleds(new ArrayList<String>());
		ret.getKilleds().add("潘金莲");
		ret.getKilleds().add("潘金莲");
		ret.getKilleds().add("潘金莲");
		
		return ret;
	}
	@Bean(name = "p5")
	public Person getPerson5() {
		Person p=Person.PersonFactory();
		p.setName("王英");
		return p;
	}
	
	@Bean(name="hello1")//对应bean 的id
	@Scope(value = "prototype")//原型模式，单例模式
	public Hello getHello1() {
		return new Hello();
	}
	
	
	@Bean(name="hello2")
	@Lazy
	public Hello getHello2() {
		return new Hello();
	}
	

}
