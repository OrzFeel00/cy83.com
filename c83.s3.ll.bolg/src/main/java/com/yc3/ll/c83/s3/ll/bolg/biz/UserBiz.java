package com.yc3.ll.c83.s3.ll.bolg.biz;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.yc3.ll.c83.s3.ll.bolg.bean.User;
import com.yc3.ll.c83.s3.ll.bolg.dao.UserMapper;

@Service
public class UserBiz {
	
	@Resource
	private UserMapper umapper;
	
	public void register(User user)throws BizException {
		//可以忽略字段的验证
		//经行同名验证
		if(umapper.countByAccount(user.getAccount())>0) {
			throw new BizException("用户已存在");
		}
		umapper.insert(user);
	}
	
	public User login(User user) throws BizException{
		User dbuser=umapper.selectByLogin(user);
		if(dbuser==null) {
			throw new BizException("用户或者密码错误");
		}
		return dbuser;
	}

}
