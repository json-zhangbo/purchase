package com.zhongran.purchase.dao;

import java.util.List;

import com.zhongran.purchase.entity.Qresult;
import com.zhongran.purchase.vo.QresultAll;

public interface QresultDao {

	public List<Qresult> getAll();
	public List<QresultAll> getAllP();
}
