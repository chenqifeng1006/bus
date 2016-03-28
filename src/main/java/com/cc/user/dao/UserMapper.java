package com.cc.user.dao;

import java.util.List;

import com.cc.user.dto.User;
import com.utils.common.JPage;

public interface UserMapper {

	User getByLoginId(String loginId);
	
	List<User> queryList(JPage page);
	
	int count();
	
	void update(User user);
	
	void updateInfo(User user);
	
	void updatePassword(User user);
	
	int add(User user);
	
	void delete(User user);
	
	User getById(User user);
	
}
