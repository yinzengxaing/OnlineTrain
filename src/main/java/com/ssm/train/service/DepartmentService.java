package com.ssm.train.service;

import com.ssm.object.InputObject;
import com.ssm.object.OutputObject;

public interface DepartmentService {
	//获取部门列表
	public void getDepartmentList(InputObject inputObject, OutputObject outputObject) throws Exception;
	//添加新的部门
	public void insertDepartment(InputObject inputObject, OutputObject outputObject) throws Exception;
	//修改部门信息
	public void updateDepartment(InputObject inputObject, OutputObject outputObject) throws Exception;
	//删除部门
	public void deleteDepartment(InputObject inputObject, OutputObject outputObject) throws Exception;
	//通过部门名模糊查询
	public void getDepartmentByName(InputObject inputObject, OutputObject outputObject)throws Exception;
	//获取所有部门
	public void getAllDepartment(InputObject inputObject, OutputObject outputObject)throws Exception;
	
}
