package csd.starter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Manager {
	private Long managerId;
	private String managerName;
	private static List<Court> courtList = new ArrayList<Court>();
	static{
		courtList.add(new Court(1l, Double.valueOf(20), "East"));
		courtList.add(new Court(2l, Double.valueOf(30), "West"));
		courtList.add(new Court(3l, Double.valueOf(25), "North"));
		courtList.add(new Court(4l, Double.valueOf(15), "South"));
	}
	
	private static Map<Long, Order> orderList = new HashMap<Long, Order>();
	
	public static List<Court> getCourtList() {
		return courtList;
	}

	public static void setCourtList(List<Court> courtList) {
		Manager.courtList = courtList;
	}

	public Long getManagerId() {
		return managerId;
	}

	public void setManagerId(Long managerId) {
		this.managerId = managerId;
	}
	
	public String getManagerName() {
		return managerName;
	}

	public void setManagerName(String managerName) {
		this.managerName = managerName;
	}
	
	public void receiverOrder(Order order) {
		orderList.put(order.getOrderId(), order);
	}	
	
	public static boolean isCourtAvailable(Order order) {
		
		
		return false;
	}
	
}
