package csd.starter;

import org.junit.Test;

import java.util.HashMap;
import java.util.function.Function;

import static org.junit.Assert.assertEquals;

public class MainTest {

    @Test
    public void lambda() {
        Function<Integer, Integer> inc = (i) -> i + 1;

        assertEquals(Integer.valueOf(3), inc.apply(2));

    }
    
    @Test
    public void testPod() {

        assertEquals(1,TennisReservation.lookup(10,10));

    }

}
