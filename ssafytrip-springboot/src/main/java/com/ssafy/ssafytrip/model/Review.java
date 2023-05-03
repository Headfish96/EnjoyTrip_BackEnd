package com.ssafy.ssafytrip.model;

import lombok.Data;

@Data
public class Review {
	private String attractionCode;
	private int reviewCode;
	private int score;
	private String content;
	private int userCode;
	private String userName;
	private int attractonId;
}
