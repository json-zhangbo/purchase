package com.zhongran.purchase.dao;

import java.util.List;

import com.zhongran.purchase.entity.Result;

public interface ResultDao {
	public List<Result> getAll();
	public void insert(Result res);
	public List<Result> getAllP(String docnum);
}
