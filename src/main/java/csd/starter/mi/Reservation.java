package csd.starter.mi;

import csd.starter.ppt.Court;
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

    public Integer fee() {
        return 10 * time_range.getInt();
    }
}
