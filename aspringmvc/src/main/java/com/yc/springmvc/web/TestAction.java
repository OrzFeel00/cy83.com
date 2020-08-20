package com.yc.springmvc.web;

import java.io.InputStream;
import java.io.OutputStream;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.yc.damai.bean.DmUser;

/*springmvc地址通配符
 *   ？ 一个字符
 *   *  任意多个字符  1-n个字符
 *   **  任意中间级数0-n级目录
 * 
 * */
@RestController  ///与@SessionAttributes  sssss!有冲突 要在@RestController标注的类中给会话添加属性，要通过注入会话对象的方法
@RequestMapping("user")//也可以加载在类上，表示类里面的所有控制器共同的虚拟路径
//@SessionAttributes(names="loginedUser,loginedPwd",types = Date.class) // names 用于监控数据模型中出现指定名字的对象   tyoes 用于监控数据模型中出现的的对象
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
	//cookie也是头域的一部分，但是cookie带结构
	@RequestMapping("**/cookie")
	//添加cooki   document.cookie="user=zhenga"
	public String cookie(@CookieValue String user,@CookieValue int age,@RequestHeader String cookie) {
		return user+"<br>"+age+"<br>"+cookie;
	}
	
	
	/*能注入：请求对象，响应对象，会话对象
	 * 添加servlet依赖这里要
	 * 但是不能注入 应用上下文对象
	 * */
	@RequestMapping("**/servlet")
	//user/a/del  user/a/b/c/del
	public String servlet(HttpServletRequest request, HttpServletResponse response,HttpSession session
			,InputStream in ,OutputStream out) {
		
		return ""+request+"<br>"+response+"<br>"+session+"<br>"+in+"<br>"+out;
		
	}
	/*
	 * 地址参数： get请求的参数格式：
	 * 标准url中的参数格式  longing?user=root&pwd=123
	 * 地址参数格式： /root/123/login   Springmvc里的格式
	 * */
	@RequestMapping("/{user}/{pwd}/login")
	public String login(@PathVariable("user")String user,@PathVariable()String pwd) {
		
		
		return user+"<br>"+pwd;
	}
	
	/*
	 * 
	 * 会话对象的注入
	 * @SessionAttribute 从会话中获取一个指定对象 加在方法参数上
	 * @SessionAttributes 将指定的对象设置到会话中    会监控model 如果又符合的数据类型会自动的存到会话   加在类上
	 * SPringlemvc 数据模型     Model  (map集合)在请求过程中用于临时保存数据的对象
	 * */
	
	 @RequestMapping("/{user}/{pwd}/login.do")
	public String logindo(@PathVariable("user")String user,
			@PathVariable()String pwd,
			Model model,//该方法没有用
			HttpSession session) {
		
		DmUser du=new DmUser();
		du.setEname(user);
		du.setPassword(pwd);
		//将用户对象数据添加到数据模型中
		session.setAttribute("loginedUser",du);
		session.setAttribute("loginedPwd",pwd);
		session.setAttribute("now",new Date());
		//session.setAttribute("age", 100);

		
		return user.toString()+"<br>"+pwd.toString();
	}
	
	
	
	
	
	//验证会话中的数据
	@RequestMapping("testLogin")
	public String testLogin(
			@SessionAttribute("loginedUser") DmUser du,
			@SessionAttribute("now") Date date
			){
		
		
		return du+"<br>"+date+"<br>";
		
	}
	
	


	
}
