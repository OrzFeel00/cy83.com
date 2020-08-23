package com.yc.springmvc.action;

import javax.xml.ws.RequestWrapper;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

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
	
	//第一也第三组
	@RequestMapping(path = "toPage",params = "flag")
	public String Totao() {
		
		return "taobao";
	}
	@RequestMapping(path = "toPage",params = "type=1")
	public String Totao2() {
		
		return "taobao";
	}
	@RequestMapping(path = "toPage",params = {"type!=1","!flag"})
	public String tobaidu1() {
		
		return "baidu";
	}
	
	

	@GetMapping({"toPage","toBaidu","baidu/page","form.do"})
	public String lo1( ) {
		
		return  "baidu";
	}
	
	@PostMapping("form.do")
	public String lo(String value ) {
		
		return  "taobao";
	}
	
	
	
	@ResponseBody//将一个Java对象转化为json格式的数据
	@RequestMapping("call.do")
	public String call(int type ) {
		
		return type ==2 ?  "taobao":"baidu";
	}

	@ResponseBody//将一个Java对象转化为json格式的数据
	@RequestMapping("call1.do")
	public Result call1(int type ) {
		Result r=new Result();
		r.setUrl(type ==2 ? "toTaobao": "toBaidu");
		r.setMsg(type ==2 ? "跳转淘宝":"跳转百度");
		return r;
	}
	
	@ResponseBody//将一个Java对象转化为json格式的数据
    @PostMapping(path = "exec.do")
	public Result exec() {
		Result r=new Result();
		r.setMsg("跳转百度");
		r.setUrl("toBaidu");
		
		return r;
	}
	@ResponseBody//将一个Java对象转化为json格式的数据
	@GetMapping(path = "exec.do")
	public Result exec1() {
		Result r=new Result();
		r.setMsg("跳转淘宝");
		r.setUrl("toTaobao");
		
		return r;
	}
	   
	

	
	
	
}
