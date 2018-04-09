package com.zhongran.purchase.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import org.springframework.format.annotation.DateTimeFormat;

public class GroupBasic implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//@Column(name = "ID")
	//@GeneratedValue(strategy = GenerationType.IDENTITY)
	private String id;
	private String groupName;//组份名称
	private double storageMoney;//入库成本
	private double motionvIs;//运动粘度
	private double sulfurCon;//硫含量
	private double nethot;//净热值
	private double motionTemp;//粘度温度
	private double md;//密度
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private String optime;//创建日期
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getGroupName() {
		return groupName;
	}
	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}
	public double getStorageMoney() {
		return storageMoney;
	}
	public void setStorageMoney(double storageMoney) {
		this.storageMoney = storageMoney;
	}
	public double getMotionvIs() {
		return motionvIs;
	}
	public void setMotionvIs(double motionvIs) {
		this.motionvIs = motionvIs;
	}
	public double getSulfurCon() {
		return sulfurCon;
	}
	public void setSulfurCon(double sulfurCon) {
		this.sulfurCon = sulfurCon;
	}
	public double getNethot() {
		return nethot;
	}
	public void setNethot(double nethot) {
		this.nethot = nethot;
	}
	public double getMotionTemp() {
		return motionTemp;
	}
	public void setMotionTemp(double motionTemp) {
		this.motionTemp = motionTemp;
	}
	public String getOptime() {
		return optime;
	}
	public void setOptime(String optime) {
		this.optime = optime;
	}
	public double getMd() {
		return md;
	}
	public void setMd(double md) {
		this.md = md;
	}
	
	
	
}
