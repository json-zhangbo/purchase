package com.zhongran.purchase.service;

import java.util.List;

import com.zhongran.purchase.entity.Qresult;
import com.zhongran.purchase.vo.QresultAll;

public interface QresultService {

	public List<Qresult> getAll();
	public List<QresultAll> getAllP();
}
