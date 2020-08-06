package com.yc.favorite.util;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MyBatisHelper {

	private static	SqlSessionFactory sqlSessionFactory;
	static {
		//动态块，实例块
		try {
			// mybatis 配置文件
			String resource = "mybatis.xml";
			// 读入配置文件
			InputStream inputStream = Resources.getResourceAsStream(resource);
			// 构建会话工厂  ==>  23 设计模式   工厂模式
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
			// 开启会话
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
		throw new RuntimeException(e);
		}
		
		
	}
	 
	 public static SqlSession openSession() {
		
		 return sqlSessionFactory.openSession();
		 
	 }
	
}
