package com.ssm.train.dao;

import java.util.Map;

public interface LoginMapper {
	public Map<String, Object> selectUser(Map<String,Object> map) throws Exception;
}
