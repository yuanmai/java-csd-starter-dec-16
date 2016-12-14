package csd.starter;

import org.junit.Assert;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Scanner;

/**
 * Created by jay on 12/13/16.
 */
public class FeerateTester {

    @Test
    public void feerate(){
        Assert.assertEquals(5, Feerate.fee(8));
        Assert.assertEquals(10, Feerate.fee(13));
        Assert.assertEquals(20, Feerate.fee(21));

        Assert.assertEquals(9999, Feerate.fee(7));
        Assert.assertEquals(9999, Feerate.fee(23));


    }

//    @Test
//    public void uat(){
//        ByteArrayOutputStream ba = new ByteArrayOutputStream();
//        System.setOut(new PrintStream(ba));
//        Main.e2e(new ByteArrayInputStream("8".getBytes()));
//        Assert.assertEquals("5\n", ba.toString());
//    }


}
