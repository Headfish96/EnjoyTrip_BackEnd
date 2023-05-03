package com.ssafy.ssafytrip.model.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ssafy.ssafytrip.model.Attraction;
import com.ssafy.ssafytrip.model.Gugun;
import com.ssafy.ssafytrip.model.Plan;
import com.ssafy.ssafytrip.model.Review;
import com.ssafy.ssafytrip.model.Sido;
import com.ssafy.ssafytrip.model.mapper.AttractionMapper;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AttractionServiceImpl implements AttractionService {
	public final AttractionMapper attractionMapper;
	
	//관광지 정보 검색, 조회
	@Override
	public List<Attraction> getInfo(Attraction attraction) throws Exception {
		return attractionMapper.selectAttraction(attraction);
	}

	//내가 찜한 관광지 조회
	@Override
	public List<Attraction> getMyPlace(int userCode) throws Exception {
		return attractionMapper.selectByUserCode(userCode);
	}

	//찜한 목록이 많은 관광지 반환
	@Override
	public List<Attraction> getHotPlace() throws Exception {
		return attractionMapper.selectHotPlace();
	}

	//선택한 관광지를 포함한 정보의 리스트를 반환
	@Override
	public List<Plan> getPlan(int attractionCode) throws Exception {
		return attractionMapper.selectPlanByAttraction();
	}

	//내가 찜하기한 관광지 정보를 반환
	@Override
	public void addMyPlace(int attractionCode, int userCode) throws Exception {
		attractionMapper.insertMyPlace(attractionCode, userCode);
	}

	//선택한 관광지 리뷰 달기
	@Override
	public void addReview(Review review) throws Exception {
		attractionMapper.insertReview(review);
	}

	//선택한 관광지의 리뷰 정보륿 반환
	@Override
	public List<Review> getReview(String attractionCode) throws Exception {
		return attractionMapper.selectReview(attractionCode);
	}

	//관광지 정보를 카테고리를 선택해서 검색
	//12:관광지, 14:문화시설, 15:축제공연행사, 25:여행코스, 28:레포츠, 32:숙박, 38:쇼핑, 39:음식점
	@Override
	public List<Attraction> getPlaceByCagegory(String category) throws Exception {
		int categoryCode = -1;
		if(category.equals("관광지")) {
			categoryCode = 12; 
		} 
		else if(category.equals("문화시설")) {
			categoryCode = 14;
		}
		else if(category.equals("축제공연행사")) {
			categoryCode = 15;
		}
		else if(category.equals("여행코스")) {
			categoryCode = 25;
		}
		else if(category.equals("레포츠")) {
			categoryCode = 28;
		}
		else if(category.equals("숙박")) {
			categoryCode = 32;
		}
		else if(category.equals("쇼핑")) {
			categoryCode = 38;
		}
		else if(category.equals("음식점")) {
			categoryCode = 39;
		}
		return attractionMapper.selectAttractionByCategory(categoryCode, 10);
	}

	//관광지 정보를 랜덤으로 출력
	@Override
	public List<Attraction> getRandomPlace() throws Exception {
		return attractionMapper.selectInfoRandom();
	}
	
	
	

	@Override
	public List<Gugun> getGugunList(String sidoCode) throws Exception {
		return attractionMapper.selectGugun(sidoCode);
	}

	@Override
	public List<Sido> getSidoList() throws Exception {
		return attractionMapper.selectSido();
	}

	//12:관광지, 14:문화시설, 15:축제공연행사, 25:여행코스, 28:레포츠, 32:숙박, 38:쇼핑, 39:음식점
	@Override
	public List<Attraction> getAttractionList(String sido, String gugun, String keyword) throws Exception {
		return attractionMapper.selectAttractionList(sido, gugun, keyword);
	}

	@Override
	public Attraction getDetailInfo(String contentId) throws Exception {
		return attractionMapper.selectAttractionDetail(contentId);
	}

}
