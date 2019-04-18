package com.ssm.train.dao;

import java.util.List;
import java.util.Map;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;


public interface DepartmentMapper {
	List<Map<String,Object>> getDepartmentList(Map<String, Object> map , PageBounds bounds) throws Exception;//获取部门列表
	void insertDepartment(Map<String, Object> map) throws Exception;//添加新部门
	void updateDepartment(Map<String, Object> map) throws Exception;//添加新部门
}
