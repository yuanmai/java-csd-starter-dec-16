package csd.starter;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

/**
 * Created by shushuxu on 2016/12/13.
 */
public class PrimeFactorTest {

    @Test
    public void factors(){
        Assert.assertEquals(Arrays.asList(2,2,2), Prime.extractPrimeFactor(8));
    }
}
