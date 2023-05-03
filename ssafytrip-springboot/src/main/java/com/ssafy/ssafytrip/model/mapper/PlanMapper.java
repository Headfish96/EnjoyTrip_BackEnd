package com.ssafy.ssafytrip.model.mapper;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.ssafytrip.model.Plan;
import com.ssafy.ssafytrip.model.PlanAttraction;
import com.ssafy.ssafytrip.model.PlanUser;
import com.ssafy.ssafytrip.model.User;

@Mapper
public interface PlanMapper {

	void insertNewPlan(Plan plan) throws SQLException;

	List<Plan> selectMyPlan(String userCode) throws SQLException;

	void deletePlan(int planCode) throws SQLException;

	void insertPlanAttractions(PlanAttraction planAttractions)throws SQLException;

	void deletePlanAttraction(String planAttractionCode) throws SQLException;

	List<PlanAttraction> selectPlanAttraction(int plancode) throws SQLException;

	void insertNewUser(PlanUser planUser) throws SQLException;

	void deleteUser(PlanUser planUser) throws SQLException;

	List<User> selectUser(int planCode) throws SQLException;

	void updatePlan(Plan plan) throws SQLException;

}
