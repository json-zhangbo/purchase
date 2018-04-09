package com.zhongran.purchase.entity;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

public class QualityIndex {
	//@Column(name = "ID")
	//@GeneratedValue(strategy = GenerationType.IDENTITY)
	private String id;
	private int quaitid;//指标id
	private String optioinCode;//条件
	private double cost;
	private String status;
	private String docNum;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public int getQuaitid() {
		return quaitid;
	}
	public void setQuaitid(int quaitid) {
		this.quaitid = quaitid;
	}
	public String getOptioinCode() {
		return optioinCode;
	}
	public void setOptioinCode(String optioinCode) {
		this.optioinCode = optioinCode;
	}
	public double getCost() {
		return cost;
	}
	public void setCost(double cost) {
		this.cost = cost;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getDocNum() {
		return docNum;
	}
	public void setDocNum(String docNum) {
		this.docNum = docNum;
	}
	
	
}
