package com.yc3.ll.c83.s3.ll.bolg.dao;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import com.yc3.ll.c83.s3.ll.bolg.bean.Comment;

public interface CommentMapper {
	
	@Insert("insert into comment values (null,"
			+ "#{articleid},#{content},#{createby},now())")
	public int insert(Comment comm);
	
	@Select("select * from comment where articleid=#{articleid}")
	public List<Comment> selectByAricle(int articleid);//在实体类用 integer（integer有null，数据库有null 。。在这方法里可以用用int，应为这里肯定是不为o的）

}
