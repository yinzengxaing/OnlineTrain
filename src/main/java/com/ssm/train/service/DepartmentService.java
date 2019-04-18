package com.ssm.train.service;

import com.ssm.object.InputObject;
import com.ssm.object.OutputObject;

public interface DepartmentService {
	public void getDepartmentList(InputObject inputObject, OutputObject outputObject) throws Exception;//获取部门列表
	public void insertDepartment(InputObject inputObject, OutputObject outputObject) throws Exception;//添加新的部门
	public void updateDepartment(InputObject inputObject, OutputObject outputObject) throws Exception;//修改部门信息
}
