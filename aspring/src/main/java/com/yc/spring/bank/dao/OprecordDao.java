package com.yc.spring.bank.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.yc.spring.bank.bean.Oprecord;

//银行的操作流水dao
@Repository
public class OprecordDao {
	@Autowired
	   private JdbcTemplate jdbcTemplate;//dbhelp
	
	public int insert(int id ,double omoney) {
		return jdbcTemplate.update("insert into oprecord values(null,?,?,null,now())",id,omoney);
		
	}
	public List<Oprecord> selectById(int accountid){
		String sql="selec * from oprecord where accountid = ?";
		Object[] args= {accountid} ;
		
		return jdbcTemplate.query(sql,args,new RowMapper<Oprecord>() {

			public Oprecord mapRow(ResultSet rs, int rowNum) throws SQLException {
				Oprecord o=new Oprecord();
				o.setId(rs.getInt("id"));
				o.setAccountid(rs.getInt("accountid"));
				o.setOpmoney(rs.getDouble("opmoney"));
				o.setCharge(rs.getDouble("charge"));
				o.setOptime(rs.getTimestamp("optiom"));
				
				return o;
			}
			
		});
		
	}
	

}
