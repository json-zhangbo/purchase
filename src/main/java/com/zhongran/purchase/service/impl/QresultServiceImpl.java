package com.zhongran.purchase.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhongran.purchase.dao.QresultDao;
import com.zhongran.purchase.entity.Qresult;
import com.zhongran.purchase.service.QresultService;
import com.zhongran.purchase.vo.QresultAll;
@Service
public class QresultServiceImpl implements QresultService {
   @Autowired
   QresultDao qresultDao;
	@Override
	public List<Qresult> getAll() {
		
		return qresultDao.getAll();
	}
	@Override
	public List<QresultAll> getAllP() {
		return qresultDao.getAllP();
	}

}
