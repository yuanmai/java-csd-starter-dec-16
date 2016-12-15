package csd.starter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.GregorianCalendar;
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

	public void bookCourt() throws ParseException {
		session.serverSay("bookBegin", "please enter book info");
		
		session.serverSay("book.date", "please enter book date");
		String dateStr = session.lisClient("book.date");
        session.serverSay("book.time", "please enter book time");
        String time = session.lisClient("book.time");

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH");
		Date date = sdf.parse(dateStr + " " + time);
		if(!dateIntervalLessThan7(date)) {
			session.serverSay("book.result", "You cannot reserver a court more than 7 days ahead");
			return;
		}
		
		session.serverSay("book.court", "please enter book court");
		String courtName = session.lisClient("book.court");
		Court court = new Court(courtName);

        session.serverSay("book.period", "please enter book period(in hours)");
        String periodStr = session.lisClient("book.period");
        if(Integer.valueOf(periodStr) > 2) {
            session.serverSay("book.period", "You cannot reserver a court for more than 2 hours");
            return;
        }
//		String[] infoList = clientInfo.split(":");
//		if (orderList.containsKey(clientInfo)) {
//			session.serverSay("book", "This court has been booked!");
//		} else {
//			orderList.put(clientInfo, null);
//			session.serverSay("book", "you have booked " + infoList[0] + " " + infoList[1] + "!");
//		}

	}
	
	private boolean dateIntervalLessThan7(Date date) {
		GregorianCalendar calendar = new GregorianCalendar();
		calendar.add(GregorianCalendar.DAY_OF_MONTH, 7);
		if(calendar.before(date)) {
			return false;
		}
		return true;
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
			locationList.add(location + "--" + court.getCourtName());
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
		    try {
                this.bookCourt();
            } catch (Exception e) {
		        e.printStackTrace();
            }

		}
		
		
	}

}
