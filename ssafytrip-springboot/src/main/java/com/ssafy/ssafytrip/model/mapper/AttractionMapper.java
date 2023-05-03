package com.ssafy.ssafytrip.model.mapper;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.ssafytrip.model.Attraction;
import com.ssafy.ssafytrip.model.Gugun;
import com.ssafy.ssafytrip.model.Plan;
import com.ssafy.ssafytrip.model.Review;
import com.ssafy.ssafytrip.model.Sido;

@Mapper
public interface AttractionMapper {

	List<Attraction> selectAttraction(Attraction attraction) throws SQLException;
	List<Attraction> selectHotPlace() throws SQLException;
	List<Plan> selectPlanByAttraction() throws SQLException;
	void insertReview(Review review) throws SQLException;
	List<Review> selectReview(String attractionCode) throws SQLException;
	List<Attraction> selectInfoRandom() throws SQLException;
	
	
	
	List<Attraction> selectByUserCode(int userCode) throws SQLException;
	void insertMyPlace(int attractionCode, int userCode) throws SQLException;
	List<Attraction> selectAttractionByCategory(int categoryCode, int limit) throws SQLException;
	List<Gugun> selectGugun(String sidoCode) throws SQLException;
	List<Sido> selectSido() throws SQLException;
	List<Attraction> selectAttractionList(String sido, String gugun, String keyword);
	Attraction selectAttractionDetail(String contentId);
}