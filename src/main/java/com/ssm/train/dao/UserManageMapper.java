package com.ssm.train.dao;

import java.util.List;
import java.util.Map;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;

public interface UserManageMapper {
	//查询所有职员
	public List<Map<String, Object>> selectAllUser(Map<String, Object> map , PageBounds bounds) throws Exception;
	//查询所有管理员
	public List<Map<String, Object>> selectAllAdministrator(Map<String, Object> map , PageBounds bounds) throws Exception;
	//批量添加职员信息
	public void insertAllUser(List<Map<String,Object>> beans) throws Exception;
	//添加管理员信息
	public void insertAdministrator(Map<String,Object> bean) throws Exception;
	//修改用户信息及密码
	public void updateUserInfo(Map<String,Object> bean) throws Exception;
	//修改下一个账户开始的号
	public void updateUserStart(Map<String,Object> bean) throws Exception;
	//修改下一个账户开始的号
	public Map<String,Object> selectUserStart() throws Exception;
	//删除用户
	public void deleteUserById(Map<String,Object> bean) throws Exception;
	//按用户名查找职员
	public List<Map<String, Object>> selectUserByName(Map<String, Object> map , PageBounds bounds) throws Exception;
	//按用户名查找管理员
	public List<Map<String, Object>> selectAdministratorByName(Map<String, Object> map , PageBounds bounds) throws Exception;
	//将该用户设置为管理员
	public void updateUserToAdministrator(Map<String,Object> bean) throws Exception;
	//按id查找用户
	public Map<String,Object> selectUserById(Map<String,Object> bean) throws Exception;
	//修改密码
	public void updatePassword(Map<String,Object> bean) throws Exception; 
	
}
