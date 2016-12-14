package csd.starter;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Assert;
import org.junit.Test;

import csd.starter.vo.Count;
import csd.starter.vo.Player;


/**
 * Created by shushuxu on 2016/12/13.
 */
public class ReservationTest {
	
	@Test
	public void testRerv(){
        System.setIn(new ByteArrayInputStream("success".getBytes()));
		ByteArrayOutputStream ba = new ByteArrayOutputStream();
		System.setOut(new PrintStream(ba));

	    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/mm/dd hh");

	    Date bookDate;
		try {
			bookDate = dateFormat.parse("2016/12/13 15");
			Player p1 = new Player("user1");
			Count c1 = new Count(1);
            TennisReservation.makeReservation(bookDate, 2, p1,c1);
			Assert.assertEquals("success",ba.toString());

        } catch (ParseException e) {
			e.printStackTrace();
		}
	    
	}


}
