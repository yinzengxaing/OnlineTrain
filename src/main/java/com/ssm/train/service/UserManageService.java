package com.ssm.train.service;


import com.ssm.object.InputObject;
import com.ssm.object.OutputObject;

public interface UserManageService {
	public void selectAllUser(InputObject inputObject, OutputObject outputObject) throws Exception;//查找所有职员;
	public void selectAllAdministrator(InputObject inputObject, OutputObject outputObject) throws Exception;//查找所有管理员
	public void insertAllUser(InputObject inputObject, OutputObject outputObject) throws Exception;//批量添加职员信息
	public void insertAdministrator(InputObject inputObject, OutputObject outputObject) throws Exception;//添加管理员信息
	public void updateUserInfo(InputObject inputObject, OutputObject outputObject) throws Exception;//修改用户信息及密码
	public void selectUserStart(InputObject inputObject, OutputObject outputObject) throws Exception;//查询用户账号范围开始值
	public void deleteUserById(InputObject inputObject, OutputObject outputObject) throws Exception;//删除用户
	public void selectUserByName(InputObject inputObject, OutputObject outputObject) throws Exception;//按用户名查找职员
	public void selectAdministratorByName(InputObject inputObject, OutputObject outputObject) throws Exception;//按用户名查找管理员
	public void updateUserToAdministrator(InputObject inputObject, OutputObject outputObject) throws Exception;//按用户名查找管理员
	public void selectUserById(InputObject inputObject, OutputObject outputObject) throws Exception;//按id查找用户
	

}
