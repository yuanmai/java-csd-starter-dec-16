package csd.starter;

import java.util.HashMap;
import java.util.Map;

public class Court {
	private Long courtId;
	private Double price;
	private String location;
	
	public Court(Long courtId, Double price, String location){
		this.courtId = courtId;
		this.price = price;
		this.location = location;
	}	
	
	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public Map<String, String> getAvailableTime() {
		return availableTime;
	}

	public void setAvailableTime(Map<String, String> availableTime) {
		this.availableTime = availableTime;
	}

	private  Map<String, String> availableTime = new HashMap<String, String>();
	{
		availableTime.put("Mornong", "");
		availableTime.put("Afternoon", "");
	}
	
	
	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Long getCourtId() {
		return courtId;
	}

	public void setCourtId(Long courtId) {
		this.courtId = courtId;
	}
	

}
