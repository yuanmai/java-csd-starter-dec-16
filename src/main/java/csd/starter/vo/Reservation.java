package csd.starter.vo;

import java.time.LocalDateTime;

/**
 * Created by shushuxu on 2016/12/13.
 */
public class Reservation {
    private Player user;
    private LocalDateTime bookTime;
    private Court court;

    public Reservation(Player user, LocalDateTime bookTime, Court court) {
        this.user = user;
        this.bookTime = bookTime;
        this.court = court;
    }

    public LocalDateTime getBookTime() {
        return bookTime;
    }

    public void setBookTime(LocalDateTime bookTime) {
        this.bookTime = bookTime;
    }
    public Court getCourt() {
        return court;
    }

    public void setCourt(Court court) {
        this.court = court;
    }

    public Player getUser() {

        return user;
    }

    public void setUser(Player user) {
        this.user = user;
    }
}
