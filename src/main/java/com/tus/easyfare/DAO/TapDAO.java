package com.tus.easyfare.DAO;

import lombok.Data;

@Data
public class TapDAO {

	private Integer userId;
	private String sourcePoint;
	private String routeNumber;
	private long busNumber;
	
}
