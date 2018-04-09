package com.zhongran.purchase.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhongran.purchase.dao.GroupBasiceDao;
import com.zhongran.purchase.entity.GroupBasic;
import com.zhongran.purchase.service.GroupBasicService;
@Service
public class GroupBasicServiceImpl implements GroupBasicService{
	@Autowired
	private GroupBasiceDao groupBasiceDao;
	public void insertBasicEntity(GroupBasic groupBasic) {
		groupBasiceDao.insertBasicEntity(groupBasic);
	}
	@Override
	public List<GroupBasic> getAll() {
		return groupBasiceDao.getAll();
	}
	@Override
	public GroupBasic getOne(String id) {
		 
		return groupBasiceDao.getOne(id);
	}

}
