package csd.starter;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by jay on 12/14/16.
 */
public class TennisCalpointTest {

    @Test
    public void test1(){
        assertEquals("Fifteen Love", TennisCalpoint.cal(1, 0));

        assertEquals("Fifteen All", TennisCalpoint.cal(1, 1));

        assertEquals("Love Fifteen", TennisCalpoint.cal(0, 1));



        assertEquals("Thirty Love", TennisCalpoint.cal(2, 0));

        assertEquals("Thirty All", TennisCalpoint.cal(2, 2));

        assertEquals("Love Thirty", TennisCalpoint.cal(0, 2));


        assertEquals("Game to Server", TennisCalpoint.cal(4, 2));
        assertEquals("Game to Server", TennisCalpoint.cal(4, 0));

    }
}
