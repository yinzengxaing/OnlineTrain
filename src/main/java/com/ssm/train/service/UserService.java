package com.ssm.train.service;

import com.ssm.object.InputObject;
import com.ssm.object.OutputObject;

public interface UserService {
	public void queryUserById(InputObject inputObject, OutputObject outputObject) throws Exception;
}
