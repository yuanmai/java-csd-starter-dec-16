package csd.starter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Main {

    public static void main(String[] args) {
	    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/mm/dd hh");

	    Date bookDate;
		try {
			bookDate = dateFormat.parse("2016/12/13 15");
			TennisReservation.makeReservation(bookDate, 2, "user1");
			TennisReservation.makeReservation(bookDate, 1, "user2");
			bookDate = dateFormat.parse("2016/12/13 17");
			TennisReservation.makeReservation(bookDate, 1, "user2");
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

}
