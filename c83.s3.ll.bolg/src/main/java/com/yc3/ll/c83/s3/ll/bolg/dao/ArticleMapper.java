package com.yc3.ll.c83.s3.ll.bolg.dao;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import com.yc3.ll.c83.s3.ll.bolg.bean.Article;

public interface ArticleMapper {
	/*
	 * @Results注解来映射查询结果集到实体类属性。
	 * （1）@Results的基本用法。当数据库字段名与实体类对应的属性名不一致时，可以使用@Results映射来将其对应起来
	 * 2）@ResultMap的用法。当这段@Results代码需要在多个方法用到时，为了提高代码复用性，我们可以为这个@Results注解设置id，然后使用@ResultMap注解来复用这段代码。
	 * （3）@One的用法。当我们需要通过查询到的一个字段值作为参数，去执行另外一个方法来查询关联的内容，而且两者是一对一关系时，可以使用@One注解来便捷的实现。
	 * 比如当我们需要查询学生信息以及其所属班级信息时，需要以查询到的class_id为参数，来执行ClassesMapper中的selectById方法，从而获得学生所属的班级信息。可以使用如下代码。
	 * */
	
	@Select("select * from article order by createtime desc")
	// <ResultMap> == @Results
	@Results(id="rmAm", value={ //column为数据库字段名，porperty为实体类属性名，jdbcType为数据库字段数据类型，id为是否为主键。
			@Result(id = true, column = "id", property = "id"), // 缓存性能优化用到
			@Result(column = "categoryid", property = "categoryid"), // 
			@Result(
					column = "categoryid", 
					property = "category",
					one=@One(select="com.yc3.ll.c83.s3.ll.bolg.dao.CategoryMapper.selectById"))
			})
	public List<Article> selectByNew();

	@Select("select * from article where id = #{id}")
	@ResultMap("rmAm")
	public Article selectById( int id);                                               //keyColumn那列      其中keyProperty是Java对象的属性名！   
	//在insert这个方法上面可以返回当前的主键值。。useGeneratedKeys=true 》mybaits在执行完insert回去取字段值，,keyColumn="id",keyProperty="id>告诉这个字段叫什么名字， 
	@Insert("insert into article values (#{id},#{author},#{title},#{content},"
			+ "#{keywords},#{description},#{categoryid},#{label},#{titleimgs},"
			+ "#{status},now(),#{readcnt},#{agreecnt})")
	@Options(useGeneratedKeys=true,keyColumn="id",keyProperty="id")//自增列的主键id的获取
	 public int insert(Article a);
}
