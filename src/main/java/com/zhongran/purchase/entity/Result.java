package com.zhongran.purchase.entity;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

public class Result {
	//@Column(name = "ID")
	//@GeneratedValue(strategy = GenerationType.IDENTITY)
	private String id;
	private String basicId;
	private String docNum;//编号
	private String cstatus;
	private double mixMoney;//混合后总成本
	private double ton;//吨数
	private double maxTon;//最大吨数
	 
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getDocNum() {
		return docNum;
	}
	public void setDocNum(String docNum) {
		this.docNum = docNum;
	}
	public String getBasicId() {
		return basicId;
	}
	public void setBasicId(String basicId) {
		this.basicId = basicId;
	}
	 
	public double getMixMoney() {
		return mixMoney;
	}
	public void setMixMoney(double mixMoney) {
		this.mixMoney = mixMoney;
	}
	public double getTon() {
		return ton;
	}
	public void setTon(double ton) {
		this.ton = ton;
	}
	public double getMaxTon() {
		return maxTon;
	}
	public void setMaxTon(double maxTon) {
		this.maxTon = maxTon;
	}
	public String getCstatus() {
		return cstatus;
	}
	public void setCstatus(String cstatus) {
		this.cstatus = cstatus;
	}
	
}
