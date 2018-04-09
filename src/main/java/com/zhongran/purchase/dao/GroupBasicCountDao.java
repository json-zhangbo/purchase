package com.zhongran.purchase.dao;

import java.util.List;

import com.zhongran.purchase.entity.GroupBasicCount;
import com.zhongran.purchase.vo.GroupBasicAndCount;

public interface GroupBasicCountDao {
	public List<GroupBasicCount> getAll();
	public void insert(GroupBasicCount res);
	public List<GroupBasicAndCount> getByDocNum(String DocNum);
}
