package com.ssafy.ssafytrip.model.mapper;

import java.sql.SQLException;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.ssafytrip.model.User;

@Mapper
public interface UserMapper {
	//사용자 정보 가져오기
	User selectUser(User user) throws SQLException;
	//사용자 정보 db입력. 회원가입
	void insertUser(User user) throws SQLException;
	//유저 정보 수정
	void updateUser(User user) throws SQLException;
	//유저 정보 아이디로 가져오기
	User selectUserInfo(String userId) throws SQLException;
}
