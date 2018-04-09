package com.zhongran.purchase.service;

import java.util.List;

import com.zhongran.purchase.entity.GroupBasicCount;
import com.zhongran.purchase.vo.GroupBasicAndCount;

public interface GroupBasicCountService {
	public List<GroupBasicCount> getAll();
	public void insert(GroupBasicCount res);
	public List<GroupBasicAndCount> getByDocNum(String DocNum);
}
