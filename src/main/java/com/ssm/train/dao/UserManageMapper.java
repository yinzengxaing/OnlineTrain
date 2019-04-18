package com.ssm.train.dao;

import java.util.List;
import java.util.Map;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;

public interface UserManageMapper {
	public List<Map<String, Object>> selectAllUser(Map<String, Object> map , PageBounds bounds) throws Exception;//查询所有职员
	public List<Map<String, Object>> selectAllAdministrator() throws Exception;//查询所有管理员
	public void insertAllUser(List<Map<String,Object>> beans) throws Exception;//批量添加职员信息
	public void insertAdministrator(Map<String,Object> bean) throws Exception;//添加管理员信息
	public void updateUserInfo(Map<String,Object> bean) throws Exception;//修改用户信息及密码
	public void updateUserStart(Map<String,Object> bean) throws Exception;//修改下一个账户开始的号
	public Map<String,Object> selectUserStart() throws Exception;//修改下一个账户开始的号
	
	
	
}
