package com.yc.spring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import com.yc.spring.bean.Person;

@Configuration
@ComponentScan("com.yc.spring")
//aop不是spring提供的概念，
//spring对aop的依赖aspectj框架
@EnableAspectJAutoProxy//aop不是spring提供的概念，
public class AOPConfig {
	
	
	@Bean//未指定id方法名就是id
	public Person getPerson() {
		return new Person();
	}
	
	@Bean
	public Hello getHello() {
		return new Hello();
	}
}
