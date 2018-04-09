package com.zhongran.purchase.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhongran.purchase.dao.QualityIndexDao;
import com.zhongran.purchase.entity.QualityIndex;
import com.zhongran.purchase.service.QualityIndexService;
@Service
public class QualityIndexServiceImpl implements QualityIndexService{
    
	@Autowired
	QualityIndexDao qualityIndexDao;
	@Override
	public void insert(QualityIndex qualityindex) {
		 
		qualityIndexDao.insert(qualityindex);
	}
	@Override
	public void insertAll(List<QualityIndex> qualityindex) {
		 
		
	}

}
