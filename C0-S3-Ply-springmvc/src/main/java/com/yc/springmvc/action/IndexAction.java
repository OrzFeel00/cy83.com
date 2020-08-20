package com.yc.springmvc.action;

import javax.xml.ws.RequestWrapper;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.yc.springmvc.bean.Result;

@Controller
public class IndexAction {

	/**
	 * 	打开首页
	 */
	@RequestMapping({ "/", "index" })
	public String index(@RequestParam(defaultValue = "") String order) {
		return "index" + order;
	}
	@RequestMapping("toTaobao")
	public String toTaobao() {
		return "taobao";
	}
	@RequestMapping("toBaidu")
	public String toBaidu() {
		return "baidu";
    }
	@RequestMapping("taobao/page")
	public String toTaobao2() {
		return "taobao";
    }
	@RequestMapping("baidu/page")
	public String toBaidu1() {
		return "baidu";
    }
	@RequestMapping("*aobao")
	public String toTaobao1() {
		return "taobao";
	}
	
	@RequestMapping("**/taobao")
	public String toTaobao3() {
		return "taobao";
	}
	@RequestMapping("/{flag}/toPage")
	public String toPage(@PathVariable("flag") int flag) {
		
		return "taobao";
	}
	@RequestMapping("/{type}/toPage")
	public String toPage1(@PathVariable("type") int type) {
	if(type>1) {
		return "baidu";
		
	}else {
		return "taobao";
	}	
		
	}
	
	
	
	
	
	
	
	
	
	
	
	@GetMapping("form.do")
	public String lo1(String value ) {
		
		return  "baidu";
	}
	
	@RequestMapping("form.do")
	public String lo(String value ) {
		
		return  "taobao";
	}
	
	@RequestMapping("call.do")
	public String lo2(int type  ,String data ) {
		if(type==1) {
			data="taobao";
		}if(type==2) {
			data="baidu";
		}
		return  data;
	}
	
	
	@RequestMapping("call1.do")
	public Result lo4(int type  ,Result data) {
		
		if(type==1) {
			data.setMsg("baidu");
			data.setUrl("toBaidu");
			
		}else {
			data.setMsg("taobao");
			data.setUrl("toTaobao");
		}
		return data;
	}
	
	@RequestMapping("exec.do")
	public Result lo5(String name  ,Result data) {
		
		if(name=="跳转百度") {
			data.setMsg("baidu");
			data.setUrl("toBaidu");
			
		}else {
			data.setMsg("taobao");
			data.setUrl("toTaobao");
		}
		return data;
	}
	@RequestMapping("/{type}/toPage")
	public String toPage2(@PathVariable("type") int type) {
	if(type>1) {
		return "baidu";
		
	}else {
		return "taobao";
	}	
		
	}
	
	
	
	
}
