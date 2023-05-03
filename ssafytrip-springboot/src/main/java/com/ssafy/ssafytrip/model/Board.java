package com.ssafy.ssafytrip.model;

import lombok.Data;

@Data
public class Board {
	private int articleNo;
	private String userId;
	private String subject;
	private String content;
	private int hit;
	private String registerTime;


}