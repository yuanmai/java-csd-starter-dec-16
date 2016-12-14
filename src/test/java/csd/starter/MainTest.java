package csd.starter;

import org.junit.Test;
import org.junit.Assert;

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
	public void bookCourtTest(){
		User user=new User();
		user.session.getClientRecords().put("book.court","westCourt");
		user.session.getClientRecords().put("book.date","2016-12-15");
		user.session.getClientRecords().put("book.time","01");
		user.session.getClientRecords().put("book.period","2");
		user.bookCourt();
		Assert.assertEquals("you have booked westCourt 01,02!", user.session.getServereRecords().get("book.result"));
		user.session.getClientRecords().put("book.court","westCourt");
		user.session.getClientRecords().put("book.time","03,1");
		user.bookCourt();
		Assert.assertEquals("max is two hours", user.session.getServereRecords().get("book.result"));
	}
	
	@Test
	public void findNearestCourtTest(){		
		User user=new User();
		String courtName = user.findNearestCourt("WenYiRoad");
		Assert.assertEquals("WenYiRoad--East", courtName);		
	}
	
	
	

}
