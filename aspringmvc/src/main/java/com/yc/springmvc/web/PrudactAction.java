package com.yc.springmvc.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.yc.damai.bean.DmCart;
import com.yc.damai.bean.DmUser;

@RestController
public class PrudactAction {
	/*path==value 互为同意 。。 地址 path也是数组
	 * 
	 * method  定义响应的请求类型 如 GET POST DELETE.... 
	 * params  定义对参数的限定  如：a=100(限定请求里必须又a=100的参数)  如果只有a （就是必须又a 但是值不限定）,是给数组可以设置多个值
	 * consumes  （消费） 限定请求内容的类型
	 * headers  限定请求头域的字段值  例如：限定某个请求必须带cookie我才处理
	 * produces   产品   限定返回内容的类型
	 * 
	 * 
	 * */
	//springmvc 可以运行地址一致不冲突，一样的请求只要求参数不透， servlet不行
	@RequestMapping(path = "product.do",params = "op=query")
	public String query() {
		
		return "query产品信息";
	}
	
	@RequestMapping(path = "product.do",params = "op=add")
	public String add() {
		
		return "add添加信息";
	}
	@RequestMapping(path = "product.do",params = "op=mod" ,method = RequestMethod.POST)//没有method的话任何请求都可以
	public String mod() {
		
		return "mod  post修改信息";
	}
	//@GetMapping ==@RequestMapping(method = RequestMethod.GET)
	@GetMapping(path = "product.do",params = "op=select")
	public String select() {
		
		return "select  get添加信息";
	}
	
	@GetMapping(path = "product.do",params = "op=mgr",headers = {"Host=localhost:8080","Cookie"})
	public String mgr() {
		
		return "mgr 测试管理 ";
	}
	
	////////////请求参数////

	@GetMapping("login.do")
	public  String login(String user ,String pwd) {
		
		return user+ ":"+ pwd;
	}
	/*
	 * 如果对象接收请求参数，对象的属性名与请求参数名称映射
	 * 请求参数===》对象 的这个过程叫做  装箱   和Java的包装类一样有个装箱（把值直接赋给一个对象） 
	 * */
	@GetMapping("reg.do")
	public  String reg(DmUser user,DmCart dc) {
		
		return "<br>"+dc.toString();
	}
	
	
	
	
}
