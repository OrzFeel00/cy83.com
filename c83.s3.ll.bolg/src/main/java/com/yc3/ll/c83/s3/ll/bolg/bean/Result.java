package com.yc3.ll.c83.s3.ll.bolg.bean;
//结果对象
public class Result {
	
	private int code;//正确1错误0
	
	private String msg;//消息
	
	private Object data;//返回数据

	public Result(int code, String msg, Object data) {
		super();
		this.code = code;
		this.msg = msg;
		this.data = data;
	}
	public Result(int code, String msg) {
		super();
		this.code = code;
		this.msg = msg;
		
	}
	public Result( String msg) {
		super();
		this.code = 0;
		this.msg = msg;
		
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

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	@Override
	public String toString() {
		return "Result [code=" + code + ", msg=" + msg + ", data=" + data + "]";
	}

}
