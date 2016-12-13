package csd.starter;

import java.util.HashMap;
import java.util.Map;

public class UserSession {
	Map<String, String> servereRecords = new HashMap<String, String>();
	Map<String, String> clientRecords = new HashMap<String, String>();

	public void serverSay(String key, String value) {
		servereRecords.put(key, value);
		System.out.println(value);
	}

	public void clientSay(String key, String value) {
		clientRecords.put(key, value);
		System.out.println(value);
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
