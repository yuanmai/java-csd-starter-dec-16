package csd.starter.mi;

import csd.starter.ppt.Court;
import csd.starter.ppt.FeeRateLookUp;
import csd.starter.ppt.Player;
import csd.starter.ppt.TimeRange;

/**
 * Created by jay on 12/14/16.
 */
public class Reservation {
    private Player player;
    private Court court;
    private TimeRange time_range;

    public Reservation(Player player, Court court, TimeRange time_range) {

        this.player = player;
        this.court = court;
        this.time_range = time_range;
    }

    public int fee() {
    	int start = time_range.getStart();
    	int duration = time_range.getDuration();
    	int fee = 0;
    	int j = start;
    	for(int i = 0; i < duration; i ++){
    		fee += FeeRateLookUp.getFeerates()[j];
    		j++;
    	}
        return fee;
    }

    public boolean isSuccessful() {
        return time_range.getDuration() <= 2;
    }
    
    public Player getPlayer(){
    	return player;
    }
    
    public Court getCourt(){
    	return court;
    }
}
