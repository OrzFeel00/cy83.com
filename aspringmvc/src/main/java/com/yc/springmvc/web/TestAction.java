package com.yc.springmvc.web;

import java.io.InputStream;
import java.io.OutputStream;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/*springmvc地址通配符
 *   ？ 一个字符
 *   *  任意多个字符  1-n个字符
 *   **  任意中间级数0-n级目录
 * 
 * */
@RestController
@RequestMapping("user")//也可以加载在类上，表示类里面的所有控制器共同的虚拟路径
public class TestAction {
 
	@RequestMapping("?/add")
	//user/a/add   //user/b/add
	public String add() {
		return "add";
	}
	@RequestMapping("*/del")
	//user/a/del  user/abc/del
	public String del() {
		return "del";
	}
	@RequestMapping("**/mod")
	//user/a/del  user/a/b/c/del
	public String mod() {
		return "mod";
	}
	@RequestMapping("**/head")
	//user/a/del  user/a/b/c/del
	public String head(@RequestHeader() String accept) {
		return accept;
	}
	
	@RequestMapping("**/cookie")
	//添加cooki   document.cookie="user=zhenga"
	public String cookie(@CookieValue String user,@CookieValue int age,@RequestHeader String cookie) {
		return user+"<br>"+age+"<br>"+cookie;
	}
	
	
	/*
	 * 
	 * */
	@RequestMapping("**/servlet")
	//user/a/del  user/a/b/c/del
	public String servlet(HttpServletRequest request, HttpServletResponse response,HttpSession session
			,InputStream in ,OutputStream out) {
		
		return ""+request+"<br>"+response+"<br>"+session+"<br>"+in+"<br>"+out;
		
	}
}
