package com.yc3.ll.c83.s3.ll.bolg;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.yc3.ll.c83.s3.ll.bolg.web.LoginInterceptor;

@SpringBootApplication
@MapperScan("com.yc3.ll.c83.s3.ll.bolg.dao")
public class Application implements WebMvcConfigurer {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		// TODO Auto-generated method stub
		WebMvcConfigurer.super.addInterceptors(registry);
		
		InterceptorRegistration ir = registry.addInterceptor(new LoginInterceptor());
		// 互联网项目 ==> 拦截少数资源
		// 企业内部管理系统 ==> 拦截多数资源
		ir.addPathPatterns("/toAddArticle", 
				"/addArticle.do",
				"/comment");
	}

	
	
}
