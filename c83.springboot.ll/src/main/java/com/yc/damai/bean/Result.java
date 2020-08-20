package com.yc.damai.bean;

public class Result {
	
	private int code;//0失败 1成
	private String msg;//返回的信息
	private Object date;//返回的数据
	
	public Result(int code, String msg, Object date) {
		super();
		this.code = code;
		this.msg = msg;
		this.date = date;
	}
	public Result( String msg, Object date) {
		super();
	
		this.msg = msg;
		this.date = date;
	}
	public Result(int code, String msg) {
		super();
		this.code = code;
		this.msg = msg;

	}
	@Override
	public String toString() {
		return "Result [code=" + code + ", msg=" + msg + ", date=" + date + "]";
	}
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public Object getDate() {
		return date;
	}
	public void setDate(Object date) {
		this.date = date;
	}
	

}
