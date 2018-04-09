package com.zhongran.purchase.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhongran.purchase.dao.GroupBasicCountDao;
import com.zhongran.purchase.entity.GroupBasicCount;
import com.zhongran.purchase.service.GroupBasicCountService;
import com.zhongran.purchase.vo.GroupBasicAndCount;
@Service
public class GroupBasicCountServiceImpl implements GroupBasicCountService {
    @Autowired
    GroupBasicCountDao groupBasicCountDao;
    
	@Override
	public List<GroupBasicCount> getAll() {
		 
		return groupBasicCountDao.getAll();
	}

	@Override
	public void insert(GroupBasicCount res) {
		 
		groupBasicCountDao.insert(res);
	}

	@Override
	public List<GroupBasicAndCount> getByDocNum(String DocNum) {
		 
		return groupBasicCountDao.getByDocNum(DocNum);
	}


}
