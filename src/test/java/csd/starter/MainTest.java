package csd.starter;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
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

    	init();
    	System.out.println("Please input location x,y,  ");
    	Scanner s = new Scanner(System.in).useDelimiter("\\s*,\\s*");
    	Location location = inputLocation(s); 
        assertEquals(1,Reservation.lookup(location).getId());

    }
	public static Location inputLocation(Scanner s) {
		
		int x = s.nextInt();
        int y = s.nextInt();
        Location location = new Location(x,y);
//        System.out.println(location.get(0));
//        System.out.println(location.get(1));
        s.close();
        return location;
	}
	public void init(){
		Tennis.getTennisAssembly().add(new Tennis(1,new Location(1,2)));
		Tennis.getTennisAssembly().add(new Tennis(2,new Location(10,20)));
		Tennis.getTennisAssembly().add(new Tennis(3,new Location(30,2)));
		Tennis.getTennisAssembly().add(new Tennis(4,new Location(110,299)));
		Tennis.getTennisAssembly().add(new Tennis(5,new Location(20,13)));
		Tennis.getTennisAssembly().add(new Tennis(6,new Location(50,299)));
		Tennis.getTennisAssembly().add(new Tennis(7,new Location(80,20)));
		Tennis.getTennisAssembly().add(new Tennis(8,new Location(12,20)));
		Tennis.getTennisAssembly().add(new Tennis(9,new Location(13,24)));
		Tennis.getTennisAssembly().add(new Tennis(10,new Location(11,28)));

	}

}
