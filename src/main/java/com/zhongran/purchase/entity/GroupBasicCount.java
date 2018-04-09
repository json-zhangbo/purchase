package com.zhongran.purchase.entity;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

public class GroupBasicCount {
	//@Column(name = "ID")
	//@GeneratedValue(strategy = GenerationType.IDENTITY)
	private String id;
	private String basicId;
	private double volume;//体积
	private double massprec;//质量百分比
	private double voluMeprec;//体积百分比
	private double hotCorrect;//温度修改中洗漱
	private double visCosity;//修正后粘度系数
	private double visMassprec;//修正后的粘度与质量系数
	private double mixIngden;//混合后密度
	private double mixSulfurcont;//混合后硫的质量
	private double mixHot;//混合后热值
	private double mixCost;//混合后成本
	private String docNum;//生成编号
	private double maxTon;//最大吨数
	private double ton;//吨数
	
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
	public double getVolume() {
		return volume;
	}
	public void setVolume(double volume) {
		this.volume = volume;
	}
	public double getMassprec() {
		return massprec;
	}
	public void setMassprec(double massprec) {
		this.massprec = massprec;
	}
	public double getVoluMeprec() {
		return voluMeprec;
	}
	public void setVoluMeprec(double voluMeprec) {
		this.voluMeprec = voluMeprec;
	}
	public double getHotCorrect() {
		return hotCorrect;
	}
	public void setHotCorrect(double hotCorrect) {
		this.hotCorrect = hotCorrect;
	}
	public double getVisCosity() {
		return visCosity;
	}
	public void setVisCosity(double visCosity) {
		this.visCosity = visCosity;
	}
	public double getVisMassprec() {
		return visMassprec;
	}
	public void setVisMassprec(double visMassprec) {
		this.visMassprec = visMassprec;
	}
	public double getMixIngden() {
		return mixIngden;
	}
	public void setMixIngden(double mixIngden) {
		this.mixIngden = mixIngden;
	}
	public double getMixSulfurcont() {
		return mixSulfurcont;
	}
	public void setMixSulfurcont(double mixSulfurcont) {
		this.mixSulfurcont = mixSulfurcont;
	}
	public double getMixHot() {
		return mixHot;
	}
	public void setMixHot(double mixHot) {
		this.mixHot = mixHot;
	}
	public double getMixCost() {
		return mixCost;
	}
	public void setMixCost(double mixCost) {
		this.mixCost = mixCost;
	}
	
	
}
