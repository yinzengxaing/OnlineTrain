package com.ssm.train.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;
import com.ssm.object.InputObject;
import com.ssm.object.OutputObject;
import com.ssm.train.dao.DepartmentMapper;
import com.ssm.train.dao.UserMapper;
import com.ssm.train.service.DepartmentService;
import com.ssm.train.service.UserService;
import com.ssm.train.util.JudgeUtil;
import com.ssm.train.util.ToolUtil;


@Service
public class DepartmentServiceImpl implements DepartmentService {

	@Resource
    private DepartmentMapper departmentMapper;
	//获取部门信息列表
	@Override
	public void getDepartmentList(InputObject inputObject, OutputObject outputObject) throws Exception {
		Map<String, Object> params = inputObject.getParams();
		//获取分页信息
		int page = Integer.parseInt(params.get("offset").toString())/Integer.parseInt(params.get("limit").toString());
		page++;
		int limit = Integer.parseInt(params.get("limit").toString());
		List<Map<String,Object>> departmentList = departmentMapper.getDepartmentList(params, new PageBounds(page, limit));
		PageList<Map<String, Object>> abilityInfoPageList = (PageList<Map<String, Object>>) departmentList;
		int total = abilityInfoPageList.getPaginator().getTotalCount();
		outputObject.setBeans(departmentList);
		outputObject.settotal(total); 
	}
    //添加新部门
	@Override
	public void insertDepartment(InputObject inputObject, OutputObject outputObject) throws Exception {
		Map<String,Object> params = inputObject.getParams();
		Map<String,Object> map = departmentMapper.getDepartment(params);//查询该部门是否存在
		if(map == null){//不存在添加
		params.put("createTime", ToolUtil.getTimeAndToString().substring(0, 10));
		params.put("updateTime", ToolUtil.getTimeAndToString().substring(0, 10));
		departmentMapper.insertDepartment(params);
		}
		else{
			outputObject.setreturnMessage("该部门已存在，请重新添加");
		}

	}

	@Override
	public void updateDepartment(InputObject inputObject, OutputObject outputObject) throws Exception {
		Map<String,Object> params = inputObject.getParams();
		Map<String,Object> map = departmentMapper.getDepartment(params);//查询该部门是否存在
		if(map == null){//不存在修改
		params.put("updateTime", ToolUtil.getTimeAndToString().substring(0, 10));
		departmentMapper.updateDepartment(params);
		}
		else{
			outputObject.setreturnMessage("该部门已存在，清楚重新添加");
		}

	}
	//删除部门
	@Override
	public void deleteDepartment(InputObject inputObject, OutputObject outputObject) throws Exception {
		Map<String,Object> params = inputObject.getParams();
		departmentMapper.deleteDepartment(params);
	}
	//通过部门名模糊查询
	@Override
	public void getDepartmentByName(InputObject inputObject, OutputObject outputObject) throws Exception {
		Map<String, Object> params = inputObject.getParams();
		//获取分页信息
		int page = Integer.parseInt(params.get("offset").toString())/Integer.parseInt(params.get("limit").toString());
		page++;
		int limit = Integer.parseInt(params.get("limit").toString());
		List<Map<String,Object>> departmentList = departmentMapper.getDepartmentByName(params, new PageBounds(page, limit));
		PageList<Map<String, Object>> abilityInfoPageList = (PageList<Map<String, Object>>) departmentList;
		int total = abilityInfoPageList.getPaginator().getTotalCount();
		outputObject.setBeans(departmentList);
		outputObject.settotal(total); 
		
	}
	@Override
	public void getAllDepartment(InputObject inputObject, OutputObject outputObject) throws Exception {
		List<Map<String,Object>> beans = departmentMapper.getAllDepartment();
		outputObject.setBeans(beans);
		
	}


}
