package csd.starter;

import csd.starter.vo.Court;
import csd.starter.vo.Price;
import org.junit.Assert;
import org.junit.Test;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by shushuxu on 2016/12/14.
 */
public class CourtTest {

    Court c1 = new Court(1);

    @Test
    public void count_fee_should_be_display_by_hour(){
        List<Price> priceList = new ArrayList<>();
        priceList.add(new Price(LocalTime.of(9,0), 50));
        priceList.add(new Price(LocalTime.of(10,0), 50));
        priceList.add(new Price(LocalTime.of(19,0), 100));
        c1.setPriceList(priceList);

        Assert.assertEquals("[Price{time=09:00, fee=50}, Price{time=10:00, fee=50}, Price{time=19:00, fee=100}]",c1.listPrice());

    }
}
