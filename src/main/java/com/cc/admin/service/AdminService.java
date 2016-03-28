package com.cc.admin.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cc.admin.dao.AdminMapper;
import com.cc.admin.dto.Admin;
import com.utils.common.JPage;

@Service
public class AdminService {
	
	@Autowired
	private AdminMapper adminMapper;
	
	public List<Admin> queryList(JPage page){
		return this.adminMapper.queryList(page);
	}
	
	public int count(){
		return this.adminMapper.count();
	}
	
	
	public Admin getByLoginId(String loginId){
		return this.adminMapper.getByLoginId(loginId);
	}
	
	public void updateInfo(Admin admin){
		this.adminMapper.updateInfo(admin);
	}
	
	public void updatePassword(Admin admin){
		this.adminMapper.updatePassword(admin);
	}
	
	public void update(Admin admin){
		this.adminMapper.update(admin);
	}
	
	public int add(Admin admin){
		return this.adminMapper.add(admin);
	}
	
	public void delete(Admin admin){
		this.adminMapper.delete(admin);
	}
	

}