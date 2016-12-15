package csd.starter.vo;

import java.util.List;
import java.util.Scanner;

public class Geography {

	private Geography(){}
	
	public static Court userSearchTennnis(List<Court> courts){
    //	System.out.println("Please input location, format: 1,2,  ")
    	Scanner s = new Scanner(System.in).useDelimiter("\\s*,\\s*");
    	Location location = inputLocation(s);
    	return lookup(location, courts);
    	
	}
	//return tennis ID
	public static Court lookup(Location location, List<Court> courts) {
		Court nearestTennis = courts.get(1);
		int distance = nearestTennis.distance(location);

		for (Court tennis : courts){
			if (tennis.distance(location) < distance){
				nearestTennis = tennis;
				distance = tennis.distance(location);
			}
		}
		return nearestTennis;
	}

	public static int distance(Location start, Location target){
		
		return Math.abs(start.compareLocationX(target)) + Math.abs(start.compareLocationY(target));
	}
	
	public static Location inputLocation(Scanner s) {
		
		int x = s.nextInt();
        int y = s.nextInt();
        Location location = new Location(x,y);
      //  System.out.println(location.getX())
       // System.out.println(location.getY())
        s.close();
        return location;
	}
}
