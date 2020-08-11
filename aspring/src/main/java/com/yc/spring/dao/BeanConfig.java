package com.yc.spring.dao;

import java.util.ArrayList;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;

import com.yc.spring.Hello;
import com.yc.spring.bean.Person;

@Configuration  
public class BeanConfig {
	@Bean(name="odao")
	public OracleUserDao getOracleUserDao() {
		return new OracleUserDao();
	}
	@Bean(name="mdao")
	public MySQLUserDao getMySQLUserDao() {
		return new MySQLUserDao();
	}
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
		ret.getKilleds().add("2潘金莲");
		ret.getKilleds().add("2潘金莲");
		
		return ret;
	}
	
	@Bean(name="hello1")//对应bean 的id
	@Scope(value = "prototype")//原型模式，单例模式
	public Hello getHello1() {
		return new Hello();
	}
	
	@Bean(name="hello2")
    @Lazy("")
	public Hello getHello2() {
		return new Hello();
	}
	

}
