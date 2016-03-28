package com.cc.admin.dao;

import java.util.List;

import com.cc.admin.dto.Admin;
import com.utils.common.JPage;

public interface AdminMapper {
	
	Admin getByLoginId(String loginId);
	
	List<Admin> queryList(JPage page);
	
	int count();
	
	void updateInfo(Admin admin);
	
	void updatePassword(Admin admin);
	
	void update(Admin admin);
	
	int add(Admin admin);
	
	void delete(Admin admin);
}