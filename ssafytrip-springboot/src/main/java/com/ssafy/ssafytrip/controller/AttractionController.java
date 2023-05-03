package com.ssafy.ssafytrip.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.annotation.JsonAppend.Attr;
import com.ssafy.ssafytrip.model.Attraction;
import com.ssafy.ssafytrip.model.Gugun;
import com.ssafy.ssafytrip.model.Plan;
import com.ssafy.ssafytrip.model.Review;
import com.ssafy.ssafytrip.model.Sido;
import com.ssafy.ssafytrip.model.User;
import com.ssafy.ssafytrip.model.service.AttractionService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/attraction")
@RequiredArgsConstructor
public class AttractionController {

	private final AttractionService attractionService;
	
	//관광지 정보 조회(검색)
	//parameter : attraction dto
	@GetMapping("/info")
	List<Attraction> getAttractionInfo(@RequestBody Attraction attraction) throws Exception {
		List<Attraction> attractionInfo = attractionService.getInfo(attraction);
		return attractionInfo;
	}
	
	@GetMapping("/gugun")
	@ResponseStatus(value = HttpStatus.ACCEPTED)
	List<Gugun> getGugunList(@RequestParam String sidoCode) throws Exception{
		List<Gugun> gugunList = attractionService.getGugunList(sidoCode);
		return gugunList;
	}
	
	@GetMapping("/sido")
	@ResponseStatus(value = HttpStatus.ACCEPTED)
	List<Sido> getsidoList() throws Exception{
		List<Sido> sidoList = attractionService.getSidoList();
		return sidoList;
	}
	
	@GetMapping("/attraction-list")
	@ResponseStatus(value = HttpStatus.ACCEPTED)
	List<Attraction> getAttractionList(@RequestParam(required = false) String sido, @RequestParam(required = false) String gugun, @RequestParam(required = false) String keyword) throws Exception{
		List<Attraction> list = attractionService.getAttractionList(sido, gugun, keyword);
		return list;
	}
	
	@GetMapping("/detail-info")
	@ResponseStatus(value = HttpStatus.ACCEPTED)
	Attraction getDetailInfo(@RequestParam String contentId) throws Exception {
		Attraction attraction = attractionService.getDetailInfo(contentId);
		return attraction;
	}
	
	
	
	//내가 찜한 관광지 추가
	//parameter : attraction dto, user id
	@PostMapping("/myplace")
	ResponseEntity<?> addMyPlace(@RequestParam int attractioncode, @RequestParam int usercode) throws Exception {
		attractionService.addMyPlace(attractioncode, usercode);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
	
	//내가 찜한 관광지 조회
	//parameter : user id
	@GetMapping("/myplace")
	List<Attraction> getMyPlace(@RequestParam int usercode) throws Exception {
		List<Attraction> list = attractionService.getMyPlace(usercode);
		return list;
	}
	
	//hotplace를 반환, 찜하기 많은 순으로 반환한다.
	@GetMapping("/best")
	List<Attraction> getPlace() throws Exception{
		List<Attraction> list = attractionService.getHotPlace();
		return list;
	}
	
	//hotplace를 카테고리 별로 반환, 각 카테고리 별로 찜하기 순서 많은 순서로 반환한다.
	@GetMapping("/best/{category}")
	List<Attraction> getPlaceByCategory(@PathVariable String category) throws Exception{
		List<Attraction> list = attractionService.getPlaceByCagegory(category);
		return list;
	}
	
	//random 여행지 반환
	@GetMapping("/random")
	List<Attraction> getRandomPlace() throws Exception{
		List<Attraction> list = attractionService.getRandomPlace();
		return list;
	}
	
	//여행지를 포함한 여행 코스를 추천
	@GetMapping("/course")
	List<Plan> getPlan(@RequestParam int attractioncode) throws Exception{
		List<Plan> list = attractionService.getPlan(attractioncode);
		return list;
	}
	
	//여행지에 리뷰 남기기
	//parameter : review dto
	@PostMapping("/review")
	public ResponseEntity<?> addReview(@RequestBody Review review) throws Exception {
		attractionService.addReview(review);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}	
	
	//여행지 리뷰 보기
	//parameter : attraction id
	@GetMapping("/review")
	List<Review> getAttractionReview(@RequestParam String attractioncode) throws Exception{
		return attractionService.getReview(attractioncode);
	}
}
