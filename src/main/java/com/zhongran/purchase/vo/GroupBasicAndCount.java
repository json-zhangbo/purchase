package com.zhongran.purchase.vo;

public class GroupBasicAndCount {

	private String id;//基础数据计算表id
	private String basicId;//基础数据表id
	private String groupName;//组份名称
	private double ton;//吨数
	private double cost;//混合后成本
	private String docNum;//生成编号
	
	
	public String getDocNum() {
		return docNum;
	}
	public void setDocNum(String docNum) {
		this.docNum = docNum;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getBasicId() {
		return basicId;
	}
	public void setBasicId(String basicId) {
		this.basicId = basicId;
	}
	public String getGroupName() {
		return groupName;
	}
	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}
	public double getTon() {
		return ton;
	}
	public void setTon(double ton) {
		this.ton = ton;
	}
	public double getCost() {
		return cost;
	}
	public void setCost(double cost) {
		this.cost = cost;
	}
	
	
}
