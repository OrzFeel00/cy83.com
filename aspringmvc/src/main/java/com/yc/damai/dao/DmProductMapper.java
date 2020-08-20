package com.yc.damai.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.yc.damai.bean.DmProduct;

public interface DmProductMapper {
	List<DmProduct>selectAll();

	DmProduct selectById(int id); 
	
	List<DmProduct> selectByObj(DmProduct dp);
	/*
	 * 根据枚举的分类id查询
	 * cids 存放分类id的数组 0-n
	 * mybatis不能识别参数的名称
	 * @Param
	 * */
	
	List<DmProduct> selectByCids(@Param("cids")  int[] cids);
	
	int update(DmProduct dp);

}
