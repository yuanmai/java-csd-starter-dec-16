package csd.starter;

import csd.starter.mi.Payment;
import csd.starter.mi.Reservation;
import csd.starter.ppt.Court;
import csd.starter.ppt.Player;
import csd.starter.ppt.TimeRange;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.assertEquals;


/**
 * Created by jay on 12/14/16.
 */
public class PaymentTest {

    private Player player = new Player("Wenjun");
    private Court court = new Court("TT");
    private TimeRange time_range = new TimeRange(8, 2);

    @Test
    public void paymement_should_des_10_after_reserved_and_pay(){

        Reservation reservation = new Reservation(player, court, time_range);
        Payment payment = new Payment(player);

        int pa = payment.account();
        payment.pay(reservation);

        assertEquals(20, pa - payment.account());

    }
}
