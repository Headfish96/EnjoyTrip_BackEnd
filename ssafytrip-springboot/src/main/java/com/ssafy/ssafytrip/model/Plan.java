package com.ssafy.ssafytrip.model;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;

@Data
public class Plan {
	private int userCode;
	private int planCode;
	private String startDate;
	private String endDate;
	private String title;
	private String content;
	private int likeCount;
	
	private List<PlanAttraction> attraction;
}
