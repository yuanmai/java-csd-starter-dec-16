package csd.starter.mi;

import java.util.logging.Level;
import java.util.logging.Logger;

public class nullReservationException extends Exception {


	public nullReservationException() {
		Logger log = Logger.getLogger("nullReservationException"); 
        log.setLevel(Level.INFO); 
       log.warning("Reservation is NULL! ");
	}

	

}
