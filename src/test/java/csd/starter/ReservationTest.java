package csd.starter;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import csd.starter.vo.Court;
import csd.starter.vo.Location;
import csd.starter.vo.Player;

/**
 * Created by shushuxu on 2016/12/13.
 */
public class ReservationTest {
	Player p1 = new Player("user1");
	Player p2 = new Player("user2");
	Location location_1 = new Location(1,2);
	Court c1 = new Court(location_1);
	SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/M/dd hh");
	ByteArrayOutputStream ba;
	static TennisReservation  tennis;

	@BeforeClass
	public static void beforeClass() {
		tennis = TennisReservation.getinstance();
	}

	@Before
	public void before() {
		ba = new ByteArrayOutputStream();
		System.setOut(new PrintStream(ba));
	}

	@Test
	public void available_booking_time_should_be_success() throws ParseException {
		Date bookDate = dateFormat.parse("2016/12/14 15");

		boolean result = tennis.makeReservation(bookDate, 2, p1, c1);

		Assert.assertTrue("success", result);
	}

	@Test
	public void booking_time_should_less_than_two_hours() throws ParseException {
		Date bookDate = dateFormat.parse("2016/12/13 15");

		boolean result = tennis.makeReservation(bookDate, 3, p1, c1);

		Assert.assertTrue(!result);
	}

	@Test
	public void booking_time_should_less_than_seven_days() throws ParseException {
		Date bookDate = dateFormat.parse("2016/12/25 15");

		boolean result = tennis.makeReservation(bookDate, 2, p1, c1);

		Assert.assertTrue(!result);
	}

	@Test
	public void one_should_only_book_one_court_per_day() throws ParseException {

		Date bookDate = dateFormat.parse("2016/11/13 15");
		tennis.makeReservation(bookDate, 1, p1, c1);
		bookDate = dateFormat.parse("2016/11/13 16");

		boolean result = tennis.makeReservation(bookDate, 1, p1, c1);
		Assert.assertTrue(!result);

	}

	@Test
	public void invalid_booking_time_should_be_failed() throws ParseException {

		Date bookDate = dateFormat.parse("2016/12/13 15");
		tennis.makeReservation(bookDate, 2, p1, c1);

		bookDate = dateFormat.parse("2016/12/13 16");
		boolean result = tennis.makeReservation(bookDate, 1, p2, c1);

		Assert.assertTrue(!result);

	}
}
