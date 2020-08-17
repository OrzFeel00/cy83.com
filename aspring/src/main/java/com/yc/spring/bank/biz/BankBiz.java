package com.yc.spring.bank.biz;

import java.io.IOException;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessResourceFailureException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.yc.spring.bank.bean.Oprecord;
import com.yc.spring.bank.dao.AccuntDao;
import com.yc.spring.bank.dao.OprecordDao;

//银行业务类
/*
 * 开户： 向account表增添记录新增
 * 存取款：修改account表余额（修改），记录流水（新增）
 * 卡号 密码 余额
 * 转账：a账户减少b账户增加
 * 查询：根据卡号查询余额
 * 
 * */
@Service
@Transactional(rollbackFor = {SQLException.class,IOException.class})
public class BankBiz {
	@Autowired
	private AccuntDao adao;
    @Autowired
	private OprecordDao  odao;
    //开户
	public void register(int id,String pwd,double money) {
		adao.insert(id, pwd, money);	
		odao.insert(id, money);
	}
	//存取款
	@Transactional(rollbackFor = BizException.class)
	public void save(int id,double money) throws BizException {
		
		adao.updata(id, money);	
	/*	try {
	    if(money>999) {
	    	throw new BizException("存取款金额不能大于999");
	    }}catch(BizException e) {
	    	//将该编译期异常转型为运行期异常
	    	throw new DataAccessResourceFailureException("异常转型",e);
	    }	
	 */   
		if(money>999) {
	    	throw new BizException("存取款金额不能大于999");
	    }
		odao.insert(id, money);
	}
	//转账
	public void transfer(int id1,int id2,double money) throws BizException {
		save(id1, -money);
		
		save(id2, -money);
		
		
		
		
	}

}
