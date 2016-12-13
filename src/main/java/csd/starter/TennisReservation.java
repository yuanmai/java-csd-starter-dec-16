package csd.starter;

import csd.starter.vo.Player;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import csd.starter.vo.*;

public class TennisReservation {
	public static Map<Integer,Map> reservedList = new ConcurrentHashMap<Integer, Map>();

	public static DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("yyyy/mm/dd hh");

	public static void makeReservation(Date bookTime, int hour, Player user, Count count){
		if(isAvaliable(bookTime, hour, count)){
			reservation(bookTime, hour, user, count);
			System.out.print("success");
		}else{
			System.out.print("failed");
		}
	}
	
	public static boolean isAvaliable(Date bookTime, int hour,  Count count){
		LocalDateTime time = LocalDateTime.ofInstant(bookTime.toInstant(), ZoneId.systemDefault());

		if(! reservedList.containsKey(count.getCountId())){
			return Boolean.valueOf(true);
		}else {
			Map<String, Reservation> reserved = reservedList.get(count.getCountId());
			for (int i = 1; i <= hour; i++) {
				if (reserved.get(dateFormat.format(time)) != null) {
					return Boolean.valueOf(false);
				}
				time.plusHours(1);
			}
		}
		return Boolean.valueOf(true);
	}
	
	public static void reservation(Date bookTime, int hour, Player user,  Count count){
		LocalDateTime time = LocalDateTime.ofInstant(bookTime.toInstant(), ZoneId.systemDefault());

		if(! reservedList.containsKey(count.getCountId())) {
			reservedList.put(count.getCountId(), new ConcurrentHashMap<String, Reservation>());
		}

		for(int i = 1; i<= hour; i++){
			Reservation reservation = new Reservation(user, time,count);
			reservedList.get(count.getCountId()).put(dateFormat.format(time), user.getUserName() );
			time.plusHours(1);
		}
	}
}
