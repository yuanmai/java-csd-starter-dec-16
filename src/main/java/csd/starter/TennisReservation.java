package csd.starter;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import csd.starter.vo.Court;
import csd.starter.vo.Player;
import csd.starter.vo.Reservation;


public class TennisReservation {
	public static Map<Integer,Map> reservedList = new ConcurrentHashMap<Integer, Map>();
	public static Map<String,Map<Integer,Reservation>> reserveMap = new ConcurrentHashMap <String,Map<Integer,Reservation>>();
	public static Map<Integer,Court> countList = new ConcurrentHashMap<Integer, Court>();

	public static void setAllCounts(List<Court> courts){
		countList.clear();
		for(Court court : courts){
			countList.put(court.getCountId(), court);
		}
	}
	public static DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("yyyy/mm/dd hh");
	
	public static  SimpleDateFormat simpleFormat=new SimpleDateFormat("yyyy/MM/dd");

	public static void makeReservation(Date bookTime, int hour, Player user, Court court){
		if(isAvailable(bookTime, hour, user,court)){
			reservation(bookTime, hour, user, court);
			System.out.print("success");
		}else{
			System.out.print("failed");
		}
	}

	public static boolean isAvailable(Date bookTime, int hour, Player user,  Court court){
		LocalDateTime time = LocalDateTime.ofInstant(bookTime.toInstant(), ZoneId.systemDefault());
		if(hour > 2){
			return Boolean.valueOf(false);
		}

		if(time.minusDays(7).isAfter(LocalDateTime.now())){
			return Boolean.valueOf(false);
		}
		String date=simpleFormat.format(bookTime);
		Map<Integer,Reservation> dayReserve=reserveMap.get(date);
		if(dayReserve==null){
			return Boolean.valueOf(true);
		}
		for(Map.Entry<Integer, Reservation> entry: dayReserve.entrySet()){
			if(user.getUserName().equals(entry.getValue().getUser().getUserName())){
				return Boolean.valueOf(false); 
			}
		}
		if(!reserveMap.containsKey(date)){
			return Boolean.valueOf(true);
		}else {	
			Map<Integer, Reservation> reserved = reserveMap.get(date);
			for (int i = 1; i <= hour; i++) {
				if (reserved.get(time.getHour()) != null) {
					return Boolean.valueOf(false);
				}
				time = time.plusHours(1);
			}
		}
		return Boolean.valueOf(true);
	}
	
	public static void reservation(Date bookTime, int hour, Player user,  Court court){
		LocalDateTime time = LocalDateTime.ofInstant(bookTime.toInstant(), ZoneId.systemDefault());
		String date=simpleFormat.format(bookTime);
		if(! reserveMap.containsKey(date)) {
			reserveMap.put(date, new ConcurrentHashMap<Integer, Reservation>());
		}
		
		for(int i = 1; i<= hour; i++){
			Reservation reservation = new Reservation(user, time, court);
			reserveMap.get(date).put(time.getHour(), reservation);
			
			time = time.plusHours(1);
		}
	}
}
