package com.ssafy.ssafytrip.model.service;

import java.util.List;

import com.ssafy.ssafytrip.model.Plan;
import com.ssafy.ssafytrip.model.PlanAttraction;
import com.ssafy.ssafytrip.model.PlanUser;
import com.ssafy.ssafytrip.model.User;

public interface PlanService {

	void addNewPlan(Plan plan) throws Exception;

	List<Plan> getMyPlan(String userCode) throws Exception;

	void deletePlan(int planCode) throws Exception;

	void setDetailPlanInfo(Plan planAttractions) throws Exception;

	void deletePlanAttraction(String planAttractionCode) throws Exception;

	List<PlanAttraction> getDetailPlan(int plancode) throws Exception;

	void addNewUser(PlanUser planUser) throws Exception;

	void deleteUser(int planCode, int userCode) throws Exception;

	List<User> getUserList(int planCode) throws Exception;

	void modifyPlan(Plan plan) throws Exception;

}
