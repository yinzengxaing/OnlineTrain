package com.ssm.train.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;
import com.ssm.object.InputObject;
import com.ssm.object.OutputObject;
import com.ssm.train.dao.CourseManageMapper;
import com.ssm.train.dao.UserMapper;
import com.ssm.train.service.CourseManageService;
import com.ssm.train.service.UserService;


@Service
public class CourseManageServiceImpl implements CourseManageService {

	@Resource
	private CourseManageMapper courseManagemapper;
    
	//查找所有课程信息
	@Override
	public void selectAllCourseInfo(InputObject inputObject, OutputObject outputObject) throws Exception {
		Map<String, Object> params = inputObject.getParams();
		//获取分页信息
		int page = Integer.parseInt(params.get("offset").toString())/Integer.parseInt(params.get("limit").toString());
		page++;
		int limit = Integer.parseInt(params.get("limit").toString());
		List<Map<String,Object>> courseList = courseManagemapper.selectAllCourseInfo(params, new PageBounds(page, limit));
		PageList<Map<String, Object>> abilityInfoPageList = (PageList<Map<String, Object>>) courseList;
		int total = abilityInfoPageList.getPaginator().getTotalCount();
		outputObject.setBeans(courseList);
		outputObject.settotal(total); 
	}
   //查找未完成课程    
	@Override
	public void selectUnfinishCourse(InputObject inputObject, OutputObject outputObject) throws Exception {
		Map<String, Object> params = inputObject.getParams();
		//获取分页信息
		int page = Integer.parseInt(params.get("offset").toString())/Integer.parseInt(params.get("limit").toString());
		page++;
		int limit = Integer.parseInt(params.get("limit").toString());
		List<Map<String,Object>> courseList = courseManagemapper.selectUnfinishCourse(params, new PageBounds(page, limit));
		PageList<Map<String, Object>> abilityInfoPageList = (PageList<Map<String, Object>>) courseList;
		int total = abilityInfoPageList.getPaginator().getTotalCount();
		outputObject.setBeans(courseList);
		outputObject.settotal(total); 
		
	}
	

}
