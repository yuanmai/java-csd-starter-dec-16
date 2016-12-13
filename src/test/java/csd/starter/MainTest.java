package csd.starter;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

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
		user.session.getClientRecords().put("book","westCourt:moring");
		user.bookCourt();
		Assert.assertEquals("you have booked westCourt moring!", user.session.getServereRecords().get("book"));
		user.session.getClientRecords().put("book","westCourt:moring");
		user.bookCourt();
		Assert.assertEquals("This court has been booked!", user.session.getServereRecords().get("book"));
	}

}
