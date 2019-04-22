package com.ssm.train.dao;

import java.util.List;
import java.util.Map;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;


public interface DepartmentMapper {
	List<Map<String,Object>> getDepartmentList(Map<String, Object> map , PageBounds bounds) throws Exception;//获取部门列表
	void insertDepartment(Map<String, Object> map) throws Exception;//添加新部门
	void updateDepartment(Map<String, Object> map) throws Exception;//修改部 门信息
	Map<String,Object> getDepartment(Map<String, Object> map) throws Exception;//查询该部门是否存在
	void deleteDepartment(Map<String, Object> map) throws Exception;//删除部门getDepartmentByName
	List<Map<String,Object>> getDepartmentByName(Map<String, Object> map , PageBounds bounds) throws Exception;//通过部门名模糊查询
	List<Map<String,Object>> getAllDepartment() throws Exception;//查找所有
}
