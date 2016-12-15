package csd.starter;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import csd.starter.vo.Court;
import csd.starter.vo.Player;
import csd.starter.vo.Reservation;


public class TennisReservation {
	
	private static TennisReservation tennis=new TennisReservation();
	private static Map<String,Map<Integer,Reservation>> reservedMap = new ConcurrentHashMap <String,Map<Integer,Reservation>>();
	private static Map<Court,Court> countList = new ConcurrentHashMap<Court, Court>();

	private TennisReservation(){
		
	}
	public static TennisReservation getinstance(){
		if(tennis==null){
			tennis=new TennisReservation();
		}
		return tennis;
	}
	public  void setAllCounts(List<Court> courts){
		countList.clear();
		for(Court court : courts){
			countList.put(court, court);
		}
	}

	public  boolean makeReservation(Date bookTime, int hour, Player user, Court court){
		if(isAvailable(bookTime, hour, user)){
			reservation(bookTime, hour, user, court);
			return true;
		}else{			
			return false;
		}
	}
	
	public  boolean isAvailable(Date bookTime, int hour, Player user){
		SimpleDateFormat simpleFormat = new SimpleDateFormat("yyyy/MM/dd");

		LocalDateTime time = LocalDateTime.ofInstant(bookTime.toInstant(), ZoneId.systemDefault());
		if(hour > 2){
			return false;
		}

		if(time.minusDays(7).isAfter(LocalDateTime.now())){
			return false;
		}
		String date=simpleFormat.format(bookTime);
		String result=checkMultiReservation(date, user);
		if(result!=null){
			return Boolean.valueOf(result);
		} 
		
		if(!reservedMap.containsKey(date)){
			return true;
		}	
		Map<Integer, Reservation> reserved = reservedMap.get(date);
		for (int i = 1; i <= hour; i++) {
			if (reserved.get(time.getHour()) != null) {
					return false;
			}
			time = time.plusHours(1);
		}
		
		return true;
	}
	private String checkMultiReservation(String date, Player user) {
	
		String result=null;
		Map<Integer,Reservation> dayReserve=reservedMap.get(date);
		if(dayReserve==null){
			result= "true";
		}
		for(Map.Entry<Integer, Reservation> entry: dayReserve.entrySet()){
			if(user.getUserName().equals(entry.getValue().getUser().getUserName())){
				result ="false"; 
			}
		}
		return result;
	}
	
	public  void reservation(Date bookTime, int hour, Player user,  Court court){
		SimpleDateFormat simpleFormat = new SimpleDateFormat("yyyy/MM/dd");
		LocalDateTime time = LocalDateTime.ofInstant(bookTime.toInstant(), ZoneId.systemDefault());
		String date=simpleFormat.format(bookTime);
		if(! reservedMap.containsKey(date)) {
			reservedMap.put(date, new ConcurrentHashMap<Integer, Reservation>());
		}
		
		for(int i = 1; i<= hour; i++){
			Reservation reservation = new Reservation(user, time, court);
			reservedMap.get(date).put(time.getHour(), reservation);
			
			time = time.plusHours(1);
		}
	}
}
