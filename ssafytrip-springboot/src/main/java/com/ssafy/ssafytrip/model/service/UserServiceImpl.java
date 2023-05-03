package com.ssafy.ssafytrip.model.service;

import org.springframework.stereotype.Service;

import com.ssafy.ssafytrip.model.User;
import com.ssafy.ssafytrip.model.mapper.UserMapper;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
	private final UserMapper userMapper;
	@Override
	public User login(User user) throws Exception {
		return userMapper.selectUser(user);
	}

	@Override
	public void regist(User user) throws Exception {
		userMapper.insertUser(user);
	}

	@Override
	public void modifyInfo(User user) throws Exception {
		userMapper.updateUser(user);
	}

	@Override
	public User getUserInfo(String userId) throws Exception {
		return userMapper.selectUserInfo(userId);
	}

}
