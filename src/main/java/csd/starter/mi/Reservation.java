package csd.starter.mi;

import csd.starter.ppt.Court;
import csd.starter.ppt.feeRateLookUp;
import csd.starter.ppt.Player;
import csd.starter.ppt.TimeRange;
import csd.starter.ppt.feeRateLookUp;

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
    	int i = duration;
    	int j = start;
    	for(;i>=0;i--){
    		fee += feeRateLookUp.feeRates[j-1];
    		j++;
    	}
        return fee;
    }
}
