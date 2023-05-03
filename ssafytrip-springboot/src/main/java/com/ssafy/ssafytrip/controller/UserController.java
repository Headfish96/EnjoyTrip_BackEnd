package com.ssafy.ssafytrip.controller;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpSession;

import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.ssafytrip.model.User;
import com.ssafy.ssafytrip.model.service.UserService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/user")
//@RequiredArgsConstructor
public class UserController {
	public final UserService userService;
	
	public UserController(UserService userService) {
		this.userService = userService;
	}
	
	@GetMapping
	public ResponseEntity<?> test() {
		return new ResponseEntity("success", HttpStatus.CREATED);
	}
	
	//로그인
	//parameter : user dto
	@PostMapping("/login")
	@ResponseStatus(value=HttpStatus.CREATED)
//	public ResponseEntity<User> login(@RequestBody User user) throws Exception {
	public User login(@RequestBody User user) throws Exception {
		User userInfo = userService.login(user);
		//return new ResponseEntity<>(userInfo, HttpStatus.ACCEPTED);
		return userInfo;
	}
	
	//회원가입 
	//parameter : user dto
	@PostMapping("/regist")
	@ResponseStatus(value=HttpStatus.ACCEPTED)
	public String registUser(@RequestBody User user) throws Exception {
		userService.regist(user);
		return "regist success";
	}
	
	//로그 아웃
	@GetMapping("/logout")
	@ResponseStatus(value=HttpStatus.ACCEPTED)
	public String logout() {
		return "logout success";
	}

	//유저 정보 반환 
	//parameter: 유저 아이디
	@GetMapping("user-info")
	@ResponseStatus(value=HttpStatus.ACCEPTED)
	public User getUserInfo(@RequestParam String id) throws Exception {
		System.out.println("controller " + id);
		return (User) userService.getUserInfo(id);
	}
	
	/*
	 * 유저 정보 수정
	 * parameter : user dto
	 */
	@PostMapping("modify")
	@ResponseStatus(value=HttpStatus.ACCEPTED)
	public User modifyUserInfo(@RequestBody User user) throws Exception {
		userService.modifyInfo(user);
		return user;
	}
}
