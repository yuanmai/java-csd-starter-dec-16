package csd.starter;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Random;

public class Order {
	private Long orderId;
	private String client;
	private Date startTime;
	private int period;
	private Court court; 
	private Date endTime;

	public Order(String client, Date startTime, int period, Court court) {
		this.orderId = new Random().nextLong();
		this.client = client;
		this.startTime = startTime;
		this.period = period;
		this.endTime = addDateByHours(startTime, period);
		this.court = court;
	}

	private static Date addDateByHours(Date srcDate, int hours) {
		GregorianCalendar calendar = new GregorianCalendar();
		calendar.setTime(srcDate);
		calendar.add(GregorianCalendar.HOUR, hours);
		return calendar.getTime();
	}

	public String getClient() {
		return client;
	}

	public void setClient(String client) {
		this.client = client;
	}

	public Date getStartTime() {
		return startTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}
	
	public Court getCourt() {
		return court;
	}

	public void setCourt(Court court) {
		this.court = court;
	}

	public Date getEndTime() {
		return endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	public Long getOrderId() {
		return orderId;
	}

	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}

	@Override
	public String toString() {
		return "Order{" +
				"orderId=" + orderId +
				", client='" + client + '\'' +
				", startTime=" + startTime +
				", period=" + period +
				", court=" + court +
				", endTime=" + endTime +
				'}';
	}
}
