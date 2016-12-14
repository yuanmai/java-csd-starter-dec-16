package csd.starter;

import org.junit.Assert;
import org.junit.Test;

import static csd.starter.TennisPoints.*;

/**
 * Created by shushuxu on 2016/12/14.
 * 1:0 fifteen love
 * 0:2 love thirty
 * 2:2 thirty all
 * 3:2 forty thirty
 * 4:4 deuce
 * 5:4 advantage server
 * 5:6 advantage receiver
 * 6:6 Deuce
 * 7:5 Game to server
 */
public class TennisTest {
    @Test
    public void tennis_points(){

        Assert.assertEquals("Fifteen Love", TennisPoints.getPoints(1,0));
        Assert.assertEquals("Love Fifteen", TennisPoints.getPoints(0,1));
        Assert.assertEquals("Love Thirty", TennisPoints.getPoints(0,2));
        Assert.assertEquals("Love Forty", TennisPoints.getPoints(0,3));
        Assert.assertEquals("Fifteen All", TennisPoints.getPoints(1,1));
        Assert.assertEquals("Thirty All", TennisPoints.getPoints(2,2));
        Assert.assertEquals("Forty All", TennisPoints.getPoints(3,3));
        Assert.assertEquals("Forty Thirty", TennisPoints.getPoints(3,2));

        Assert.assertEquals("Deuce", TennisPoints.getPoints(4,4));
        Assert.assertEquals("Deuce", TennisPoints.getPoints(5,5));

        Assert.assertEquals("Advantage Server", TennisPoints.getPoints(4,3));
        Assert.assertEquals("Advantage Receiver", TennisPoints.getPoints(5,6));
        Assert.assertEquals("Game to Server", TennisPoints.getPoints(7,5));
        Assert.assertEquals("Game to Receiver", TennisPoints.getPoints(2,4));
    }
}
