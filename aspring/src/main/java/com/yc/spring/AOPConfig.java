package com.yc.spring;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan("com.yc.spring")
//aop不是spring提供的概念，
//spring对aop的依赖aspectj框架
@EnableAspectJAutoProxy//aop不是spring提供的概念，
public class AOPConfig {

}
