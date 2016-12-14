package csd.starter;

import csd.starter.vo.Court;
import csd.starter.vo.Player;
import csd.starter.vo.Reservation;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


public class TennisReservation {
	public static Map<Integer,Map> reservedList = new ConcurrentHashMap<Integer, Map>();
	public static Map<Integer,Court> countList = new ConcurrentHashMap<Integer, Court>();

	public static void setAllCounts(List<Court> courts){
		countList.clear();
		for(Court court : courts){
			countList.put(court.getCountId(), court);
		}
	}
	public static DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("yyyy/mm/dd hh");

	public static void makeReservation(Date bookTime, int hour, Player user, Court court){
		if(isAvaliable(bookTime, hour, court)){
			reservation(bookTime, hour, user, court);
			System.out.print("success");
		}else{
			System.out.print("failed");
		}
	}
	
	public static boolean isAvaliable(Date bookTime, int hour,  Court court){
		LocalDateTime time = LocalDateTime.ofInstant(bookTime.toInstant(), ZoneId.systemDefault());

		if(! reservedList.containsKey(court.getCountId())){
			return Boolean.valueOf(true);
		}else {
			Map<String, Reservation> reserved = reservedList.get(court.getCountId());
			for (int i = 1; i <= hour; i++) {
				if (reserved.get(dateFormat.format(time)) != null) {
					return Boolean.valueOf(false);
				}
				time = time.plusHours(1);
			}
		}
		return Boolean.valueOf(true);
	}
	
	public static void reservation(Date bookTime, int hour, Player user,  Court court){
		LocalDateTime time = LocalDateTime.ofInstant(bookTime.toInstant(), ZoneId.systemDefault());

		if(! reservedList.containsKey(court.getCountId())) {
			reservedList.put(court.getCountId(), new ConcurrentHashMap<String, Reservation>());
		}

		for(int i = 1; i<= hour; i++){
			Reservation reservation = new Reservation(user, time, court);
			reservedList.get(court.getCountId()).put(dateFormat.format(time), user.getUserName() );
			time = time.plusHours(1);
		}
	}
}
