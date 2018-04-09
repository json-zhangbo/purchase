package com.zhongran.purchase.dao;

import java.util.List;

import com.zhongran.purchase.entity.GroupBasic;

public interface GroupBasiceDao {

	public void insertBasicEntity(GroupBasic groupBasic);

	public List<GroupBasic> getAll();
	public GroupBasic getOne(String id);
}
