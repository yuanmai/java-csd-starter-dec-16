package csd.starter;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

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

	public void bookCourt(){
		
		String serverInfo = session.getClientRecords().get("book");
		String[] infoList = serverInfo.split(":"); 
		if(orderList.containsKey(serverInfo)){
			session.serverSay("book", "This court has been booked!");
		}
		else{
			orderList.put(serverInfo, null);
			session.serverSay("book", "you have booked " + infoList[0] + " " + infoList[1]+"!");
		}
		
	}
	
	public void login() {
		Scanner scan = new Scanner(System.in);

		session.serverSay("name", "please enter you account:");

		if(session.getClientRecords().containsKey("name")){
			name=session.getClientRecords().get("name");
			session.clientSay("name", name);
		}else{
			name = scan.nextLine();
		}


		session.serverSay("pw", "please enter you passward:");

		if(session.getClientRecords().containsKey("pw")){
			pw=session.getClientRecords().get("pw");
			session.clientSay("pw", pw);
		}else{
			pw = scan.nextLine();
		}

		session.serverSay("loginResult", name + " on line!");
		scan.close();
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

}
