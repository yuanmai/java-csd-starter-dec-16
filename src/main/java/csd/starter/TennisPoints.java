package csd.starter;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

/**
 * Created by shushuxu on 2016/12/14.
 */
public class TennisPoints {
    public static List<String> pointString = Arrays.asList("Love","Fifteen","Thirty","Forty");
    public static String getPoints(int server, int receiver){
        if(server == receiver){
            if(server < 4){
                return pointString.get(server) + " " + "All";
            }else{
                return "Deuce";
            }

        }else if(server < 4 && receiver < 4){
            return pointString.get(server) + " " +   pointString.get(receiver);
        }else{
            String result = "";

            if(BigDecimal.valueOf(server-receiver).abs().compareTo(BigDecimal.valueOf(2)) >=0){
                result = "Game to ";
            }else{
                result = "Advantage ";
            }
            if(server > receiver) {
                result += "Server";
            }else if(server < receiver){
                result += "Receiver";
            }
            return result;
        }
    }
}
