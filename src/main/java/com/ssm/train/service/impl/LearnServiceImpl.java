package com.ssm.train.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;
import com.ssm.object.InputObject;
import com.ssm.object.OutputObject;
import com.ssm.train.dao.LearnMapper;
import com.ssm.train.dao.UploadMapper;
import com.ssm.train.service.LearnService;
import com.ssm.train.service.UploadService;
import com.ssm.util.UploadUtil;
@Service
public class LearnServiceImpl implements LearnService {

	@Autowired
	private LearnMapper learnMapper;
   //获取播放列表
	@Override
	public void findAll(InputObject inputObject, OutputObject outputObject) throws Exception {
		Map<String, Object> params = inputObject.getParams();
		//获取分页信息
		int page = Integer.parseInt(params.get("offset").toString())/Integer.parseInt(params.get("limit").toString());
		page++;
		int limit = Integer.parseInt(params.get("limit").toString());
		List<Map<String,Object>> videoList = learnMapper.findAll(params, new PageBounds(page, limit));
		PageList<Map<String, Object>> abilityInfoPageList = (PageList<Map<String, Object>>) videoList;
		int total = abilityInfoPageList.getPaginator().getTotalCount();
		System.out.println(videoList.toString());
		outputObject.setBeans(videoList);
		outputObject.settotal(total); 
	}
	
	


}
