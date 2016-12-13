package csd.starter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import org.junit.Assert;
import org.junit.Test;


/**
 * Created by shushuxu on 2016/12/13.
 */
public class ReservationTest {
	
	@Test
	public void testRerv(){
        Scanner sc = new Scanner();

	    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/mm/dd hh");

	    Date bookDate;
		try {
			bookDate = dateFormat.parse("2016/12/13 15");
            TennisReservation.makeReservation(bookDate, 2, "user1");
			Assert.assertEquals("success",sc.toString());
			Assert.assertEquals("failed", TennisReservation.makeReservation(bookDate, 1, "user2"));
			bookDate = dateFormat.parse("2016/12/13 17");
			Assert.assertEquals("success", TennisReservation.makeReservation(bookDate, 1, "user2"));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    
	}


}
