package com.yc3.ll.c83.s3.ll.bolg.web;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yc3.ll.c83.s3.ll.bolg.bean.Result;
import com.yc3.ll.c83.s3.ll.bolg.bean.User;
import com.yc3.ll.c83.s3.ll.bolg.biz.BizException;
import com.yc3.ll.c83.s3.ll.bolg.biz.UserBiz;
import com.yc3.ll.c83.s3.ll.bolg.util.Utils;

@Controller
public class UserAction {
	@Resource
	private UserBiz ubiz;
	//表单提交==》页面跳转
	@PostMapping("reg.do")
	public String register( @Valid User user, Errors errors, Model m) {
		if(errors.hasErrors()) {
			m.addAttribute("errors", Utils.asMap(errors));
			m.addAttribute("user",user);
			System.out.println("11111111113");
			return "reg";
		}
		try {
			System.out.println("22222222222222");
			ubiz.register(user);
			System.out.println("333333333333");
		} catch (BizException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			errors.rejectValue("account", "account",e.getMessage());
			m.addAttribute("errors", Utils.asMap(errors));
			m.addAttribute("user",user);
			System.out.println("44444444444");
			return "reg";
		}
	//	return "index";//请求转发
		//响应重定向  redirect:/" 用响应重定向的方式跳转到/的页面
		return "redirect:/";
		
	}
	
	@GetMapping("toreg")
	public String toreg() {
		return "reg";
		
		
	}
	
	//ajax提交 ==》vue控制  405是请求方法类型错误
	@PostMapping("login.do")
	@ResponseBody
	public Result login(@Valid User user, Errors errors, HttpSession session) {
		try {
			if(errors.hasFieldErrors("account") || errors.hasFieldErrors("pwd")) {
				//将错误结果转换成map集合再返回
				Result res=new Result(0,"验证错误！",Utils.asMap(errors));
				return res;
			}
			
			User dbuser=ubiz.login(user);
			session.setAttribute("loginedUser",dbuser);
			return new Result(1,"登录成功",dbuser);
		} catch (BizException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
			return new Result(e.getMessage());
		}
		
	}
	/*
	 * 
	 * 将所有的字段验证错位，存放在map集合，一定是map
	 
	private  Map<String,String> asMap(Errors errors){
		if(errors.hasErrors()) {
			Map<String,String> ret=new HashMap<String, String>();
			for(FieldError fe : errors.getFieldErrors()) {
				ret.put(fe.getField(), fe.getDefaultMessage());
			}
			return ret;
		}else {
			return null;
		}
		
	}
	*/
	
	
	
	

}
