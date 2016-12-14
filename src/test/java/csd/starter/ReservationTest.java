package csd.starter;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

import csd.starter.vo.Court;
import csd.starter.vo.Player;
import org.junit.Assert;
import org.junit.Test;


/**
 * Created by shushuxu on 2016/12/13.
 */
public class ReservationTest {
	Player p1 = new Player("user1");
	Player p2 = new Player("user2");
	Court c1 = new Court(1);


	@Test
	public void add_one_count_size_should_be_one(){
		TennisReservation.setAllCounts(Arrays.asList(c1));

		Assert.assertEquals(1,TennisReservation.countList.size());
	}

	@Test
	public void available_booking_time_should_be_success() throws ParseException {
		ByteArrayOutputStream ba = new ByteArrayOutputStream();
		System.setOut(new PrintStream(ba));
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/M/dd hh");
		Date bookDate = dateFormat.parse("2016/12/14 15");

        TennisReservation.makeReservation(bookDate, 2, p1,c1);

        Assert.assertEquals("success",ba.toString());
	}
    @Test
    public void booking_time_should_less_than_two_hours() throws ParseException {
        ByteArrayOutputStream ba = new ByteArrayOutputStream();
        System.setOut(new PrintStream(ba));
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/M/dd hh");
        Date bookDate = dateFormat.parse("2016/12/13 15");

        TennisReservation.makeReservation(bookDate, 3, p1,c1);

        Assert.assertEquals("failed",ba.toString());
    }

    @Test
    public void booking_time_should_less_than_seven_days() throws ParseException {
        ByteArrayOutputStream ba = new ByteArrayOutputStream();
        System.setOut(new PrintStream(ba));
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/M/dd hh");
        Date bookDate = dateFormat.parse("2016/12/25 15");

        TennisReservation.makeReservation(bookDate, 2, p1,c1);

        Assert.assertEquals("failed",ba.toString());
    }

    @Test
    public void one_should_only_book_one_court_per_day() throws ParseException {
        ByteArrayOutputStream ba = new ByteArrayOutputStream();
        System.setOut(new PrintStream(ba));
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/M/dd hh");
        Date bookDate = dateFormat.parse("2016/12/25 15");

        TennisReservation.makeReservation(bookDate, 2, p1,c1);

        Assert.assertEquals("false",ba.toString());


    }
	@Test
	public void invalid_booking_time_should_be_failed() throws ParseException {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/M/dd hh");
		Date bookDate = dateFormat.parse("2016/12/13 15");
        TennisReservation.makeReservation(bookDate, 1, p1,c1);

		ByteArrayOutputStream ba = new ByteArrayOutputStream();
		System.setOut(new PrintStream(ba));
		bookDate = dateFormat.parse("2016/12/13 16");
		TennisReservation.makeReservation(bookDate, 1, p2,c1);


		Assert.assertEquals("failed",ba.toString());
	}
}
