package com.ssafy.ssafytrip.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.ssafytrip.model.Plan;
import com.ssafy.ssafytrip.model.PlanAttraction;
import com.ssafy.ssafytrip.model.PlanUser;
import com.ssafy.ssafytrip.model.User;
import com.ssafy.ssafytrip.model.service.PlanService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/plan")
@RequiredArgsConstructor
public class PlanController {
	
	private final PlanService planService;
	
	//새로운 계획을 생성하고 전송
	//parameter : plan dto
	@PostMapping("/myplan")
	public ResponseEntity<Plan> makeNewPlan(@RequestBody Plan plan) throws Exception{
		planService.addNewPlan(plan);
		return new ResponseEntity<Plan>(plan, HttpStatus.CREATED);
	}
	
	//내가 세운 여행 계획을 반환
	//parameter : user id
	@GetMapping("/myplan")
	public ResponseEntity<List<Plan>> getMyPlan(@RequestParam String userId) throws Exception{
		List<Plan> list = planService.getMyPlan(userId);
		return new ResponseEntity<List<Plan>>(list, HttpStatus.ACCEPTED);
	}

	//내가 세운 여행 계획을 삭제
	//parameter : plan code(pk)
	@DeleteMapping("/myplan")
	@ResponseStatus(value = HttpStatus.ACCEPTED)
	public void deleteDetail(@RequestParam int planCode) throws Exception {
		planService.deletePlan(planCode);
	}
	//*************************
	//세운 계획을 수정
	//parameter : plan dto
	@PutMapping("/myplan")
	@ResponseStatus(value = HttpStatus.ACCEPTED)
	public void modifyPlan(@RequestBody Plan plan) throws Exception {
		System.out.println(plan.getContent());
		planService.modifyPlan(plan);
	}
	
	//만든 계획 세부 계획을 세워 저장. 어느 날 몇번 쨰 순서로 어느 장소에 갈지 세부 계획을 저장
	//paramter : planAttraction list
	@PostMapping("/plan-attraction")
	public ResponseEntity<?> makePlanAttraction(@RequestBody Plan planAttractions) throws Exception {
		planService.setDetailPlanInfo(planAttractions);
		return new ResponseEntity<>(planAttractions, HttpStatus.CREATED);
	}

	//세부 계획 삭제
	// parameter : planAttractionCode(pk)
	@DeleteMapping("/plan-attraction")
	@ResponseStatus(value = HttpStatus.ACCEPTED)
	public void deletePlan(@RequestParam String code) throws Exception {
		planService.deletePlanAttraction(code);
	}
	
	//여행 세부 계획 반환. 
	//parameter planCode(pk)
	@GetMapping("/plan-info")
	public ResponseEntity<?> getPlanInfo(@RequestParam int plancode) throws Exception{
		List<PlanAttraction> list = planService.getDetailPlan(plancode);
		return new ResponseEntity<List<PlanAttraction>>(list, HttpStatus.ACCEPTED);
	}
	
	//여행 계획 참여자 추가
	@PostMapping("/user")
	@ResponseStatus(value = HttpStatus.ACCEPTED)
	public void addNewUser(@RequestBody PlanUser planUser) throws Exception{
		planService.addNewUser(planUser);
	}
	
	//여행 계획 참여자 삭제
	@DeleteMapping("/user")
	@ResponseStatus(value = HttpStatus.ACCEPTED)
	public void deleteUser(@RequestParam int plancode, @RequestParam int usercode) throws Exception{
		planService.deleteUser(plancode, usercode);
	}
	
	//여행 계획 참여자 조회
	@GetMapping("/user")
	@ResponseStatus(value = HttpStatus.ACCEPTED)
	public List<User> getPlanUser(@RequestParam int plancode) throws Exception {
		List<User> user = planService.getUserList(plancode);
		return user;
	}
}
