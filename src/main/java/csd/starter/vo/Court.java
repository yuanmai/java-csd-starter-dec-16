package csd.starter.vo;

import java.util.List;
public class Court {
    private Location location;
    private List<Price> priceList;
	public Court(List<Price> priceList) {		
			this.priceList = priceList;
		
	}
    public Court(Location location) {
        this.location = location;
    }
    public String listPrice() {
        return priceList.toString();
    }
    public int distance(Location target){
		
		return Math.abs(location.compareLocationX(target)) + Math.abs(location.compareLocationY(target));
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((location == null) ? 0 : location.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Court other = (Court) obj;
		if (location == null) {
			if (other.location != null)
				return false;
		} else if (!location.equals(other.location))
			return false;
		return true;
	}
  

}
