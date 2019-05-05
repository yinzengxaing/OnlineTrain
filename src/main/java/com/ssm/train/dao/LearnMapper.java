package com.ssm.train.dao;

import java.util.List;
import java.util.Map;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;

public interface LearnMapper {
	//获取播放列表
	public List<Map<String,Object>> findAll(Map<String, Object> map , PageBounds bounds) throws Exception;
	
}
