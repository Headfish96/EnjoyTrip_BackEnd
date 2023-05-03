package com.ssafy.ssafytrip.model;

import lombok.Data;

@Data
public class Attraction {
	private int contentId;
	private int contentTypeId;
	private int likeCount;
	private String title;
	private String addr1;
	private String addr2;
	private String zipcode;
	private String tel;
	private String firstImage;
	private String firstImage2;
	private int readcount;
	private String sido;
	private String gugun;
	private String lat;
	private String lng;
	private String overview;
	private double latitude;
	private double longitude;
}             
