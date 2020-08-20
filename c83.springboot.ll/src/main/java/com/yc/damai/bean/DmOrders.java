package com.yc.damai.bean;

import java.sql.Timestamp;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class DmOrders {
    private Integer id;

    private Double total;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date date;//springmvc 支持注入（utl包下）

    private Timestamp createtime;//springmvc 默认不支持

   

	private Integer state;

    private Integer uid;

    private Integer aid;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public Timestamp getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Timestamp createtime) {
        this.createtime = createtime;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public Integer getAid() {
        return aid;
    }

    public void setAid(Integer aid) {
        this.aid = aid;
    }
    
    public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return "DmOrders [id=" + id + ", total=" + total + ", date=" + date + ", createtime=" + createtime + ", state="
				+ state + ", uid=" + uid + ", aid=" + aid + "]";
	}

}