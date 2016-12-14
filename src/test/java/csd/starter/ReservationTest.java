package csd.starter;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.util.*;

import csd.starter.vo.Count;
import csd.starter.vo.Player;
import csd.starter.vo.Price;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


/**
 * Created by shushuxu on 2016/12/13.
 */
public class ReservationTest {
	Player p1 = new Player("user1");
	Player p2 = new Player("user2");
	Count c1 = new Count(1);


	@Test
	public void add_one_count_size_should_be_one(){
		TennisReservation.setAllCounts(Arrays.asList(c1));

		Assert.assertEquals(1,TennisReservation.countList.size());
	}

	@Test
	public void available_booking_time_should_be_success(){
		ByteArrayOutputStream ba = new ByteArrayOutputStream();
		System.setOut(new PrintStream(ba));

		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/mm/dd hh");

		Date bookDate;
		try {
			bookDate = dateFormat.parse("2016/12/13 15");

			TennisReservation.makeReservation(bookDate, 2, p1,c1);
			Assert.assertEquals("success",ba.toString());

		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Test
	public void invalid_booking_time_should_be_failed(){


		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/mm/dd hh");

		Date bookDate;
		try {
			bookDate = dateFormat.parse("2016/12/13 15");

			TennisReservation.makeReservation(bookDate, 2, p1,c1);

			ByteArrayOutputStream ba = new ByteArrayOutputStream();
			System.setOut(new PrintStream(ba));
			bookDate = dateFormat.parse("2016/12/13 16");
			TennisReservation.makeReservation(bookDate, 2, p2,c1);


			Assert.assertEquals("failed",ba.toString());

		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}


}
