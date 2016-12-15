package csd.starter;

import org.junit.Test;
import org.junit.Assert;

import java.text.ParseException;

public class MainTest {

	@Test
	public void loginTest() {
		User user=new User();
		user.session.getClientRecords().put("name", "xiepengqi");
		user.session.getClientRecords().put("pw", "pw");
		user.login();
		Assert.assertEquals("xiepengqi on line!", user.session.getServereRecords().get("loginResult"));
	}
	
	@Test
	public void bookCourtTestMoreThan2Hours() throws ParseException {
		User user=new User();
		user.session.getClientRecords().put("book.court","westCourt");
		user.session.getClientRecords().put("book.date","2016-12-18");
        user.session.getClientRecords().put("book.time","08");
		user.session.getClientRecords().put("book.period","3");
		user.bookCourt();
		Assert.assertEquals("You cannot reserver a court for more than 2 hours", user.session.getServereRecords().get("book.result"));
	}

    @Test
    public void bookCourtTestBefore7Days() throws ParseException {
        User user=new User();
        user.session.getClientRecords().put("book.court","westCourt");
        user.session.getClientRecords().put("book.date","2016-12-25");
        user.session.getClientRecords().put("book.time","08");
        user.session.getClientRecords().put("book.period","1");
        user.bookCourt();
        Assert.assertEquals("You cannot reserver a court more than 7 days ahead", user.session.getServereRecords().get("book.result"));
    }

	@Test
	public void findNearestCourtTest(){		
		User user=new User();
		String courtName = user.findNearestCourt("WenYiRoad");
		Assert.assertEquals("WenYiRoad--East", courtName);		
	}
	
	
	

}
