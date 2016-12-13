package csd.starter.vo;

import java.time.LocalDateTime;

/**
 * Created by shushuxu on 2016/12/13.
 */
public class Reservation {
    private Player user;
    private LocalDateTime bookTime;
    private Count count;

    public Reservation(Player user, LocalDateTime bookTime, Count count) {
        this.user = user;
        this.bookTime = bookTime;
        this.count = count;
    }

    public LocalDateTime getBookTime() {
        return bookTime;
    }

    public void setBookTime(LocalDateTime bookTime) {
        this.bookTime = bookTime;
    }
    public Count getCount() {
        return count;
    }

    public void setCount(Count count) {
        this.count = count;
    }

    public Player getUser() {

        return user;
    }

    public void setUser(Player user) {
        this.user = user;
    }
}
