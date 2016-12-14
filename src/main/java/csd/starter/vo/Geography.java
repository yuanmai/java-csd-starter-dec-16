package csd.starter.vo;

public class Geography {

	
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
	
}
