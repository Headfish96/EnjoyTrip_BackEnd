package com.ssafy.ssafytrip.model.service;

import java.util.List;

import com.ssafy.ssafytrip.model.Attraction;
import com.ssafy.ssafytrip.model.Gugun;
import com.ssafy.ssafytrip.model.Plan;
import com.ssafy.ssafytrip.model.Review;
import com.ssafy.ssafytrip.model.Sido;

public interface AttractionService {
	List<Attraction> getInfo(Attraction attraction) throws Exception;
	List<Attraction> getMyPlace(int userCode) throws Exception;
	List<Attraction> getHotPlace() throws Exception;
	List<Plan> getPlan(int attractionCode) throws Exception;
	void addMyPlace(int planCode, int userCode) throws Exception;
	void addReview(Review review) throws Exception;
	List<Review> getReview(String attractionCode) throws Exception;
	List<Attraction> getPlaceByCagegory(String category) throws Exception;
	List<Attraction> getRandomPlace() throws Exception;
	
	List<Gugun> getGugunList(String sidoCode) throws Exception;
	List<Sido> getSidoList() throws Exception;
	List<Attraction> getAttractionList(String sido, String gugun, String keyword) throws Exception;
	Attraction getDetailInfo(String contentId) throws Exception;
	
}
