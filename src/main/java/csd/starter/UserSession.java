package csd.starter;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class UserSession {
	Map<String, String> servereRecords = new HashMap();
	Map<String, String> clientRecords = new HashMap();
	public static Scanner scan;
	
	public void serverSay(String key, String value) {
		servereRecords.put(key, value);
	}

	public String lisClient(String key){
		String value;
		if(clientRecords.containsKey(key)){
			value=clientRecords.get(key);
		}else{
			value = scan.nextLine();
		}
		return value;
	}

	public Map<String, String> getServereRecords() {
		return servereRecords;
	}

	public void setServereRecords(Map<String, String> servereRecords) {
		this.servereRecords = servereRecords;
	}

	public Map<String, String> getClientRecords() {
		return clientRecords;
	}

	public void setClientRecords(Map<String, String> clientRecords) {
		this.clientRecords = clientRecords;
	}

}
