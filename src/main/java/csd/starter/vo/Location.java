package csd.starter.vo;

public class Location {
	private int x;	
	private int y;  
	
	public Location(int x, int y) {
		this.x = x;
		this.y = y;
	}

	@Override
	public String toString() {
		return  x + ":" + y ;
	}

	public int compareLocationX(Location compareLocation){
		return x-compareLocation.x;
	}
	
	public int compareLocationY(Location compareLocation){
		return y-compareLocation.y;
	}
	
}
