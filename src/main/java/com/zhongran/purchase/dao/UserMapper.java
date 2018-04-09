package com.zhongran.purchase.dao;

import java.util.List;

import com.zhongran.purchase.entity.UserEntity;

public interface UserMapper {
    List<UserEntity> getAll();
	
	UserEntity getOne(Long id);

	void insert(UserEntity user);

	void update(UserEntity user);

	void delete(Long id);
}
