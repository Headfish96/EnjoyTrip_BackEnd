package com.ssafy.ssafytrip.model;

import lombok.Data;

@Data
public class PlanAttraction {
	private Attraction attraction;
	private int sequence;
	private String date;
	private int planCode;
	private int contentId;
	private int planAttractionCode;
}
