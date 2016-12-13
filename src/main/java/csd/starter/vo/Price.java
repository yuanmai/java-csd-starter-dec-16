package csd.starter.vo;

import java.time.LocalTime;

/**
 * Created by shushuxu on 2016/12/13.
 */
public class Price {
    private LocalTime time;
    private Integer fee;

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
