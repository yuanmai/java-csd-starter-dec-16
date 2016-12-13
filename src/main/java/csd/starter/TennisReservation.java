package csd.starter;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class TennisReservation {
	public static Map<String, String> reservedList = new ConcurrentHashMap<String, String>();
	public static DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("yyyy/mm/dd hh");
	public static void makeReservation(Date bookTime, int hour, String user){
		if(isValiable(bookTime, hour)){
			reservation(bookTime, hour, user);
			System.out.print("success");
		}else{
			System.out.print("failed");
		}
	}
	
	public static boolean isValiable(Date bookTime, int hour){
		LocalDateTime time = LocalDateTime.ofInstant(bookTime.toInstant(), ZoneId.systemDefault());
		for(int i = 1; i<= hour; i++){
			if(reservedList.get(dateFormat.format(time)) != null){
				return Boolean.valueOf(false);
			}
			time.plusHours(1);
		}
		return Boolean.valueOf(true);
	}
	
	public static void reservation(Date bookTime, int hour, String user){
		LocalDateTime time = LocalDateTime.ofInstant(bookTime.toInstant(), ZoneId.systemDefault());
		for(int i = 1; i<= hour; i++){
			reservedList.put(dateFormat.format(time), user);
			time.plusHours(1);
		}
	}
}
