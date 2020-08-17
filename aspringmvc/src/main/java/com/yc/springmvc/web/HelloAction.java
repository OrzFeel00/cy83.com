package com.yc.springmvc.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//@Controller表示该类的所有方法的返回值要跳转到某个页面

@RestController//表示该类的所有方法返回值都是json数据
public class HelloAction {
	//用于标注当前方法定义的地址
	@RequestMapping("hello")
	public String hello() {
		return "hello";
	}
	

	
	
	

}
