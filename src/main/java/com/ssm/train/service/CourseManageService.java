package com.ssm.train.service;

import com.ssm.object.InputObject;
import com.ssm.object.OutputObject;

public interface CourseManageService {
	//查找所有课程信息
	public void selectAllCourseInfo(InputObject inputObject, OutputObject outputObject) throws Exception;
	//查找未完成课程
	public void selectUnfinishCourse(InputObject inputObject, OutputObject outputObject) throws Exception;
	//发布课程 
	public void publishCourse(InputObject inputObject, OutputObject outputObject) throws Exception;
	//取消发布课程
	public void cancelPublishCourse(InputObject inputObject, OutputObject outputObject) throws Exception;
	//更新课程视频播放进度
	public void updateVideoTime(InputObject inputObject, OutputObject outputObject) throws Exception;
	//查询培训
	public void selectTrain(InputObject inputObject, OutputObject outputObject) throws Exception;
	//查询考试基本信息
	public void selectCourseForTest(InputObject inputObject, OutputObject outputObject) throws Exception;
	//获取试卷
	public void selectTestList(InputObject inputObject, OutputObject outputObject) throws Exception;
}
