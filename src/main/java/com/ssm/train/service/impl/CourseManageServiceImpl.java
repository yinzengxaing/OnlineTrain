package com.ssm.train.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;
import com.ssm.object.InputObject;
import com.ssm.object.OutputObject;
import com.ssm.train.dao.CourseManageMapper;
import com.ssm.train.service.CourseManageService;


@Service
public class CourseManageServiceImpl implements CourseManageService {

	private static final String String = null;
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
	
	//发布课程 
	@Override
	public void publishCourse(InputObject inputObject, OutputObject outputObject) throws Exception {
		Map<String,Object> params = inputObject.getParams();
		courseManagemapper.publishCourse(params);
		courseManagemapper.insertTrain(params);
	}
	
	//取消发布课程
	@Override
	public void cancelPublishCourse(InputObject inputObject, OutputObject outputObject) throws Exception {
		Map<String,Object> params = inputObject.getParams();
		courseManagemapper.cancelPublishCourse(params);
		courseManagemapper.deleteTrain(params);		
	}
	
	//更新课程视频播放进度
	@Override
	public void updateVideoTime(InputObject inputObject, OutputObject outputObject) throws Exception {
		Map<String,Object> params = inputObject.getParams();
		courseManagemapper.updateVideoTime(params);
		
	}
	
	//查询培训
	@Override
	public void selectTrain(InputObject inputObject, OutputObject outputObject) throws Exception {
		Map<String,Object> params = inputObject.getParams();
		Map<String,Object> bean = courseManagemapper.selectTrain(params);
		outputObject.setBean(bean);
		
	}
	
	//查询考试基本信息
	@Override
	public void selectCourseForTest(InputObject inputObject, OutputObject outputObject) throws Exception {
		Map<String,Object> params = inputObject.getParams();
		Map<String,Object>bean = courseManagemapper.selectCourseForTest(params);
		outputObject.setBean(bean);
	}
	
	//获取试卷
	@Override
	public void selectTestList(InputObject inputObject, OutputObject outputObject) throws Exception {
		Map<String,Object> params = inputObject.getParams();
		List<Map<String,Object>> beans = courseManagemapper.selectTestList(params);
		for(int i=0;i<beans.size();i++){
			beans.get(i).put("number", i+1);
		}
		outputObject.setBeans(beans);
	}
	//提交试卷
	@Override
	public void submitTest(InputObject inputObject, OutputObject outputObject) throws Exception {
		Map<String,Object> params = inputObject.getParams();
		List<Map<String, String>> reListList = new ArrayList<>();
		int courseId = Integer.parseInt(params.get("id").toString());
		String inculdStr  =(String)params.get("include");
		System.out.println(inculdStr);
		String[] split = inculdStr.split("====");
		Map<String, String> map  = new HashMap<>();
		for (String string : split) {
			String[] split2 = string.split("-");
			map.put(split2[0], split2[1]);
		}
		Map<String, Object> bean = new HashMap<>();
		bean.put("id", courseId);
		List<Map<String,Object>> beans = courseManagemapper.selectTestList(bean);
		int sumcount=0;
		for(int i=0;i<beans.size();i++){
			String trueAnswer = beans.get(i).get("answer").toString();
			if(trueAnswer.equals(map.get(beans.get(i).get("id").toString()))){
				sumcount++;
			}
		}
		
		Map<String, Object> courseMessage = courseManagemapper.selectCourseForTest(bean);
		int grade = sumcount*Integer.parseInt(courseMessage.get("score").toString());
		Map<String,Object> grademap = new HashMap<>();
		grademap.put("grade", grade);
		outputObject.setBean(grademap);
		grademap.put("cid", params.get("id"));
		grademap.put("userid", params.get("userid"));
		courseManagemapper.updateGrade(grademap);
	}
	

}
