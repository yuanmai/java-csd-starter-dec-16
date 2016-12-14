package csd.starter;

import csd.starter.mi.Payment;
import csd.starter.mi.Reservation;
import csd.starter.ppt.Court;
import csd.starter.ppt.Player;
import csd.starter.ppt.TimeRange;
import org.junit.Test;

import static org.junit.Assert.assertEquals;


/**
 * Created by jay on 12/14/16.
 */
public class PaymentTest {

    private Player player = new Player("Wenjun");
    private Court court = new Court("TT");
    
    private TimeRange time_range = new TimeRange(0,0);
  

    @Test
    public void payment_should_des_after_reserved_and_pay() throws Exception {

    	time_range = new TimeRange(8, 2);
        Reservation reservation = new Reservation(player, court, time_range);
        Payment payment = new Payment(player);

        int pa = payment.account();
        payment.pay(reservation);

        assertEquals(10, pa - payment.account());

    }


    @Test(expected = Exception.class)
    public void payment_should_throw_exception_after_no_reserved_and_pay() throws Exception {

        Payment payment = new Payment(player);

        payment.pay(null);

    }
    

    @Test
    public void payment_with_various_feerates() throws Exception {

    	time_range = new TimeRange(8, 6);
        Reservation reservation = new Reservation(player, court, time_range);
        Payment payment = new Payment(player);

        int pa = payment.account();
        payment.pay(reservation);

        assertEquals(0, pa - payment.account());

    }
}
