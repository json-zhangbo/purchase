package com.zhongran.purchase.service;

import java.util.List;

import com.zhongran.purchase.entity.QualityIndex;

public interface QualityIndexService {

	public void insert(QualityIndex qualityindex);
	public void insertAll(List<QualityIndex> qualityindex);
}
