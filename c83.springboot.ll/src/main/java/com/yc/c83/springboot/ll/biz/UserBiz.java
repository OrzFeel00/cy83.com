package com.yc.c83.springboot.ll.biz;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.yc.c83.springboot.ll.dao.UserDao;
import com.yc.damai.bean.DmUser;
//完成
@Service
public class UserBiz {
	@Resource
	private UserDao udao;
	
	public DmUser login(String name,String pwd) throws BizException {
	DmUser user=udao.selectByLogin(name, pwd);	
	if(user==null) {
		throw new BizException("用户名不存在");
	}
	return user;
	
	}

}
