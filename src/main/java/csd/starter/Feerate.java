package csd.starter;

import java.util.Scanner;

/**
 * Created by jay on 12/13/16.
 */
public class Feerate {


    public static int fee(int i) {

        if (i >= 8 && i <= 12){
            return 5;
        }


        if (i >= 13 && i <= 17){
            return 10;
        }

        if (i >= 18 && i <= 22){
            return 20;
        }



        return 9999;
    }
}
