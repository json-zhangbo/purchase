package com.zhongran.purchase.service;

import java.util.List;

import com.zhongran.purchase.entity.QualityIndex;
import com.zhongran.purchase.entity.Result;

public interface ResultService {

	public List<Result> getAll();
	public void insert(Result res);
	public List<Result> getAllP(String docnum);
	public void inserAll(String ids,List<QualityIndex> qualityindex,String docNum);
	
	//public void countResult(String basicIds,List<QualityIndex> qualityindex);
}
