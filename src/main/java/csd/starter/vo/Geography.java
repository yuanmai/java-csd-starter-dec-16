package csd.starter.vo;

import java.util.Scanner;

public class Geography {

	public static Tennis userSearchTennnis(){
    	System.out.println("Please input location, format: 1,2,  ");
    	Scanner s = new Scanner(System.in).useDelimiter("\\s*,\\s*");
    	Location location = inputLocation(s);
    	return lookup(location);
    	
	}
	//return tennis ID
	public static Tennis lookup(Location location) {
		// TODO Auto-generated method stub
		Tennis nearestTennis = Tennis.getTennisAssembly().get(1);
		int distance = distance(nearestTennis.getLocation(), location);

		for (Tennis tennis : Tennis.getTennisAssembly()){
			if (distance(tennis.getLocation(), location) < distance){
				nearestTennis = tennis;
				distance = distance(tennis.getLocation(), location);
			}
		}
		return nearestTennis;
	}

	public static int distance(Location start, Location target){
		
		return Math.abs(start.getX()-target.getX()) + Math.abs(start.getY()-target.getY());
	}
	
	public static Location inputLocation(Scanner s) {
		
		int x = s.nextInt();
        int y = s.nextInt();
        Location location = new Location(x,y);
        System.out.println(location.getX());
        System.out.println(location.getY());
        s.close();
        return location;
	}
}
