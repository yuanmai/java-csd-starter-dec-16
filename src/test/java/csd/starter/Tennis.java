package csd.starter;

import java.util.ArrayList;
import java.util.Set;

public class Tennis {
	private int id;
	private Location location;
	private String tennisName;
	
	private static ArrayList<Tennis> tennisAssembly = new ArrayList(10);
	
	public static ArrayList<Tennis> getTennisAssembly() {
		return tennisAssembly;
	}
	public static void setTennisAssembly(ArrayList<Tennis> tennisAssembly) {
		Tennis.tennisAssembly = tennisAssembly;
	}
	public Tennis(int id, Location location){
		this.id=id;
		this.location = location;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Location getLocation() {
		return location;
	}
	public void setLocation(Location location) {
		this.location = location;
	}
	public String getTennisName() {
		return tennisName;
	}
	public void setTennisName(String tennisName) {
		this.tennisName = tennisName;
	}
}
