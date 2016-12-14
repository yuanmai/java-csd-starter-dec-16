package csd.starter;

import csd.starter.mi.Reservation;
import csd.starter.ppt.Court;
import csd.starter.ppt.Player;
import csd.starter.ppt.TimeRange;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by jay on 12/14/16.
 */
public class ReservationTest {


    private Player player = new Player("Wenjun");
    private Court court = new Court("TT");

    @Test
    public void should_fail_after_reserve_more_than_2_hours(){
        Reservation reservation = new Reservation(player, court, new TimeRange(8, 3));

        Assert.assertFalse(reservation.isSuccessful());
    }

    @Test
    public void should_succeed_after_reserve_within_2_hours(){
        Reservation reservation = new Reservation(player, court, new TimeRange(8, 2));

        Assert.assertTrue(reservation.isSuccessful());
    }
}
