package com.yc.spring.bean;

import java.util.List;

public class Person {
	private String name;
	private String id;
	private int age;
	private int Height;
    private String weight;
	
	private List<String> killeds;
	
	private Person friend;
	

	
	


	/*
	 * 静态的 工厂方法
	 * */
	
	


	

	public static Person PersonFactory() {
		Person p=new Person();
		p.setHeight(150);
		return p;
	}
	
	
	public Person getFriend() {
		return friend;
	}



	public void setFriend(Person friend) {
		this.friend = friend;
	}



	public Person() {
		
	}
	
	
	
	public Person(String name, int age, String weight) {
		super();
		System.out.println("====1====");
		this.name = name;
		this.age = age;
		this.weight = weight;
	}
	public Person(String name, int age ) {
		super();
		System.out.println("====2====");
		this.name = name;
		this.age = age;
		
	}
	public int getHeight() {
		return Height;
	}
	public void setHeight(int height) {
		Height = height;
	}
	public String getWeight() {
		return weight;
	}
	public void setWeight(String weight) {
		this.weight = weight;
	}
	
	
	
	public List<String> getKilleds() {
		return killeds;
	}
	public void setKilleds(List<String> killeds) {
		this.killeds = killeds;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	@Override
	public String toString() {
		return "Person [name=" + name + ", id=" + id + ", age=" + age + ", Height=" + Height + ", weight=" + weight
				+ ", killeds=" + killeds + ", friend=" + friend + "]";
	}


}
