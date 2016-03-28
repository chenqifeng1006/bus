package com.cc.user.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cc.user.dao.UserMapper;
import com.cc.user.dto.User;
import com.utils.common.JPage;

@Service
public class UserService {
	
	@Autowired
	private UserMapper userMapper;
	
	public List<User> queryList(JPage page){
		return this.userMapper.queryList(page);
	}
	
	public int count(){
		return this.userMapper.count();
	}
	
	public User getByLoginId(String loginId){
		return this.userMapper.getByLoginId(loginId);
	}
	
	public void updateInfo(User user){
		this.userMapper.updateInfo(user);
	}
	
	public void updatePassword(User user){
		this.userMapper.updatePassword(user);
	}
	
	
	public int add(User user){
		return this.userMapper.add(user);
	}
}