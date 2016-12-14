package csd.starter;

/**
 * Created by jay on 12/14/16.
 */
public class TennisCalpoint {

    public static String cal(int server, int receiver) {

        String[] des = {"Love", "Fifteen", "Thirty", "Forty", "All"};

        if (server < 4 && receiver < 4){
            if(server != receiver){
                return des[server] + " " + des[receiver];
            }

            if (server == receiver){
                return des[server] + " " + "All";
            }
        }

        if ((server >=4 || receiver >= 4 ) && Math.abs(server-receiver) >=2 ){
            return "Game to " + (server > receiver ? "Server" : "Receiver");
        }


        return "";

    }
}
