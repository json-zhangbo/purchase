package com.zhongran.purchase.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import org.springframework.format.annotation.DateTimeFormat;

public class Qresult {
	//@Column(name = "id")
	//@GeneratedValue(strategy = GenerationType.IDENTITY)
	private String id;
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private String resultDate;
	private String quaGroupname;
	private String fdName;
	private List<QualityIndex> qualityindex;
	
	 
	public List<QualityIndex> getQualityindex() {
		return qualityindex;
	}
	public void setQualityindex(List<QualityIndex> qualityindex) {
		this.qualityindex = qualityindex;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getResultDate() {
		return resultDate;
	}
	public void setResultDate(String resultDate) {
		this.resultDate = resultDate;
	}
	public String getQuaGroupname() {
		return quaGroupname;
	}
	public void setQuaGroupname(String quaGroupname) {
		this.quaGroupname = quaGroupname;
	}
	public String getFdName() {
		return fdName;
	}
	public void setFdName(String fdName) {
		this.fdName = fdName;
	}
	
}
