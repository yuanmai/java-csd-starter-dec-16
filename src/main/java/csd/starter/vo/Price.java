package csd.starter.vo;

import java.time.LocalTime;

/**
 * Created by shushuxu on 2016/12/13.
 */
public class Price {
    private LocalTime time;
    private Integer fee;

    @Override
    public String toString() {
        return "Price{" +
                "time=" + time +
                ", fee=" + fee +
                '}';
    }

    public Price(LocalTime time, Integer fee) {
        this.time = time;
        this.fee = fee;
    }

    public LocalTime getTime() {
        return time;
    }

    public void setTime(LocalTime time) {
        this.time = time;
    }

    public Integer getFee() {
        return fee;
    }

    public void setFee(Integer fee) {
        this.fee = fee;
    }
}
