package com.ssm.train.dao;

import java.util.List;
import java.util.Map;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;


public interface CourseManageMapper {
	//查找所有课程信息
	public List<Map<String, Object>> selectAllCourseInfo(Map<String, Object> map , PageBounds bounds) throws Exception;
	//查找未完成课程
	public List<Map<String, Object>> selectUnfinishCourse(Map<String, Object> map , PageBounds bounds) throws Exception;
}
