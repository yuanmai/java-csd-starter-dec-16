package csd.starter;

import java.util.HashMap;
import java.util.Map;

public class Manager {
	private Long managerId;
	private String managerName;
	private Map<Long, Court> courtList = new HashMap<Long, Court>();

	public Map<Long, Court> getCourtList() {
		return courtList;
	}

	public void setCourtList(Map<Long, Court> courtList) {
		this.courtList = courtList;
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

}
