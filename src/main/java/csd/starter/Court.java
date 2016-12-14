package csd.starter;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Court {
	private Long courtId;
	private String courtName;

	public Court(String courtName){
		this.courtId = new Random().nextLong();
		this.courtName = courtName;
	}	

	public String getCourtName() {
		return courtName;
	}

	public Long getCourtId() {
		return courtId;
	}

}
