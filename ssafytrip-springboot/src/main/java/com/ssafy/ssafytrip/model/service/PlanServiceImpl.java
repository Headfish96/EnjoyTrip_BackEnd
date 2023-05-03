package com.ssafy.ssafytrip.model.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ssafy.ssafytrip.model.Plan;
import com.ssafy.ssafytrip.model.PlanAttraction;
import com.ssafy.ssafytrip.model.PlanUser;
import com.ssafy.ssafytrip.model.User;
import com.ssafy.ssafytrip.model.mapper.PlanMapper;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PlanServiceImpl implements PlanService {
	public final PlanMapper planMapper;
	
	//계획 추가하기
	@Override
	public void addNewPlan(Plan plan) throws Exception {
		planMapper.insertNewPlan(plan);
		PlanUser planUser = new PlanUser();
		planUser.setPlanCode(plan.getPlanCode());
		planUser.setUserCode(plan.getUserCode());
		planMapper.insertNewUser(planUser);
	}

	//계획 리스트 반환
	@Override
	public List<Plan> getMyPlan(String userCode) throws Exception {
		return planMapper.selectMyPlan(userCode);
	}

	//계획 지우기
	@Override
	public void deletePlan(int planCode) throws Exception {
		planMapper.deletePlan(planCode);
	}

	//선택한 계획에서 관광지 정보, 날짜, 순서 입력
	@Override
	public void setDetailPlanInfo(Plan planAttractions) throws Exception {
		for(PlanAttraction attraction : planAttractions.getAttraction()) {
			planMapper.insertPlanAttractions(attraction);			
		}
	}

	//계획 디테일 정보(관광지 정보, 날짜, 순서) 지우기
	@Override
	public void deletePlanAttraction(String planAttractionCode) throws Exception {
		planMapper.deletePlanAttraction(planAttractionCode);
	}

	//계획 디테일 정보 가져오기
	@Override
	public List<PlanAttraction> getDetailPlan(int plancode) throws Exception {
		return planMapper.selectPlanAttraction(plancode);
	}

	//계획에 참여하는 인원 입력
	@Override
	public void addNewUser(PlanUser planUser) throws Exception {
		planMapper.insertNewUser(planUser);
	}

	//계획 참여하는 인원 삭제
	@Override
	public void deleteUser(int planCode, int userCode) throws Exception {
		PlanUser planUser = new PlanUser();
		planUser.setPlanCode(planCode);
		planUser.setUserCode(userCode);
		planMapper.deleteUser(planUser);
	}

	//계획 참여하는 인원 조회
	@Override
	public List<User> getUserList(int planCode) throws Exception {
		return planMapper.selectUser(planCode);
	}

	//계획 수정
	@Override
	public void modifyPlan(Plan plan) throws Exception {
		planMapper.updatePlan(plan);
	}

}
