package com.ssm.train.dao;

import java.util.List;
import java.util.Map;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;


public interface UserMapper {
	public List<Map<String, Object>> getUserList(Map<String, Object> map , PageBounds bounds) throws Exception;
}
