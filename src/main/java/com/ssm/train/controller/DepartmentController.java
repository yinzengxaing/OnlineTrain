package com.ssm.train.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ssm.object.InputObject;
import com.ssm.object.OutputObject;
import com.ssm.train.service.DepartmentService;
import com.ssm.train.service.UserService;

@Controller
public class DepartmentController {

	@Resource
	private DepartmentService departmentService;
	//获得部门列表
	@RequestMapping( "/post/DepartmentController/getDepartmentList")
	@ResponseBody
	public void getDepartmentList(InputObject inputObject,OutputObject outputObject) throws Exception {
		departmentService.getDepartmentList(inputObject, outputObject);
	}
	//添加部门
	@RequestMapping( "/post/DepartmentController/insertDepartment")
	@ResponseBody
	public void insertDepartment(InputObject inputObject,OutputObject outputObject) throws Exception {
		departmentService.insertDepartment(inputObject, outputObject);
	}
	//编辑部门信息
	@RequestMapping( "/post/DepartmentController/updateDepartment")
	@ResponseBody
	public void updateDepartment(InputObject inputObject,OutputObject outputObject) throws Exception {
		departmentService.updateDepartment(inputObject, outputObject);
	}
	
	//删除部门信息
	@RequestMapping( "/post/DepartmentController/deleteDepartment")
	@ResponseBody
	public void deleteDepartment(InputObject inputObject,OutputObject outputObject) throws Exception {
		departmentService.deleteDepartment(inputObject, outputObject);
	}

	//通过部门名模糊查询
	@RequestMapping( "/post/DepartmentController/getDepartmentByName")
	@ResponseBody
	public void getDepartmentByName(InputObject inputObject,OutputObject outputObject) throws Exception {
			departmentService.getDepartmentByName(inputObject, outputObject);
	}
	
	//查询所有部门
	@RequestMapping( "/post/DepartmentController/getAllDepartment")
	@ResponseBody
	public void getAllDepartment(InputObject inputObject,OutputObject outputObject) throws Exception {
				departmentService.getAllDepartment(inputObject, outputObject);
	}
	
	
}
