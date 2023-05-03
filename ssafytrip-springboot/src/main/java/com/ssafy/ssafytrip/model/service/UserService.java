package com.ssafy.ssafytrip.model.service;

import com.ssafy.ssafytrip.model.User;

public interface UserService {

	User login(User user) throws Exception;
	void regist(User user) throws Exception;
	void modifyInfo(User user) throws Exception;
	User getUserInfo(String userId) throws Exception;

}
