package csd.starter;

public class Tennis {
	private int id;
	private int x;
	private int y;
	private String tennisName;
	public Tennis(int id, int x, int y){
		this.id=id;
		this.x=x;
		this.y=y;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	public String getTennisName() {
		return tennisName;
	}
	public void setTennisName(String tennisName) {
		this.tennisName = tennisName;
	}
	
	
}
