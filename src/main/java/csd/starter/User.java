package csd.starter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class User {
	private String name;
	private String pw;
	public UserSession session = new UserSession();
	private Map<String, String> orderList = new HashMap<String, String>();

	public Map<String, String> getOrderList() {
		return orderList;
	}

	public void setOrderList(Map<String, String> orderList) {
		this.orderList = orderList;
	}

	public void bookCourt() {
		session.serverSay("bookBegin", "please enter book info");
		String clientInfo = session.lisClient("book");
		String[] infoList = clientInfo.split(":");
		if (orderList.containsKey(clientInfo)) {
			session.serverSay("book", "This court has been booked!");
		} else {
			orderList.put(clientInfo, null);
			session.serverSay("book", "you have booked " + infoList[0] + " " + infoList[1] + "!");
		}

	}

	public void login() {

		session.serverSay("name", "please enter you account:");
		name = session.lisClient("name");

		session.serverSay("pw", "please enter you passward:");
		pw = session.lisClient("pw");

		session.serverSay("loginResult", name + " on line!");

	}

	public String findNearestCourt(String location) {

		List<String> locationList = new ArrayList<>();
		for (Court court : Manager.getCourtList()) {
			locationList.add(location + "--" + court.getLocation());
		}
		Collections.sort(locationList);
		System.out.println(locationList.get(0));
		return locationList.get(0);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	public void onLine() {
		this.login();
		session.serverSay("afterLoginAndAsk", "what do you want to do?");
		if(session.lisClient("afterLoginAndAsk").equalsIgnoreCase("book")){
			this.bookCourt();
		}
		
		
	}

}
