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


@Service
public class DepartmentServiceImpl implements DepartmentService {

	@Resource
    private DepartmentMapper departmentMapper;
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
		System.out.println("xr");
		outputObject.setBeans(departmentList);
		outputObject.settotal(total); 
	}

	@Override
	public void insertDepartment(InputObject inputObject, OutputObject outputObject) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void updateDepartment(InputObject inputObject, OutputObject outputObject) throws Exception {
		// TODO Auto-generated method stub

	}


}
