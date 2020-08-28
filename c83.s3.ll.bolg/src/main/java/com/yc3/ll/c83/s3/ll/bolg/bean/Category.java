package com.yc3.ll.c83.s3.ll.bolg.bean;

public class Category implements java.io.Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;
	private String name;
	private String sort;
	private String introduce;
	@Override
	public String toString() {
		return "Category [id=" + id + ", name=" + name + ", sort=" + sort + ", introduce=" + introduce + "]";
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSort() {
		return sort;
	}
	public void setSort(String sort) {
		this.sort = sort;
	}
	public String getIntroduce() {
		return introduce;
	}
	public void setIntroduce(String introduce) {
		this.introduce = introduce;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	

}
