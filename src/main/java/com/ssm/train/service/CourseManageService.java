package com.ssm.train.service;

import com.ssm.object.InputObject;
import com.ssm.object.OutputObject;

public interface CourseManageService {
	//查找所有课程信息
	public void selectAllCourseInfo(InputObject inputObject, OutputObject outputObject) throws Exception;
	//查找未完成课程
	public void selectUnfinishCourse(InputObject inputObject, OutputObject outputObject) throws Exception;
}
