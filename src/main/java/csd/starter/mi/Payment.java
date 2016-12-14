package csd.starter.mi;

import csd.starter.ppt.Player;

/**
 * Created by jay on 12/14/16.
 */
public class Payment {
    private Integer account = 100;

    public Payment(Player player) {
    }

    public int account() {
        return account;

    }

    public void pay(Reservation reservation) {
        account -= reservation.fee();
    }
}
