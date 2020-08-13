package com.yc.spring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;

import com.yc.spring.bank.bean.Account;


@Configuration
public class BeanConfig {
	
	
	@Bean(name="account")
	@Lazy
	public Account getAccount() {
		return new Account();
	}
	
	@Bean(name="account1")
	@Scope(value = "prototype")
	public Account getAccount2() {
		return new Account();
	}

	
	@Bean(name="account2")
	public Account getAccount3() {
		return new Account();
	}
	
	@Bean(name="account3")
	public Account getAccount4() {
		return new Account();
	}
	@Bean(name="account4")
	public Account getAccount5() {
		return new Account();
	}
}
