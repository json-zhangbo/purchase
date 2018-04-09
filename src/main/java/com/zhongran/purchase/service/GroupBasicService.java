package com.zhongran.purchase.service;

import java.util.List;

import com.zhongran.purchase.entity.GroupBasic;

public interface GroupBasicService {

	public void insertBasicEntity(GroupBasic groupBasic);
	public List<GroupBasic> getAll();
	public GroupBasic getOne(String id);
}
