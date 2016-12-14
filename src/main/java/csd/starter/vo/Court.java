package csd.starter.vo;

/**
 * Created by shushuxu on 2016/12/13.
 */
import java.util.ArrayList;
import java.util.List;
public class Court {
    private Location location;
    private List<Price> priceList;
    private int countId;
    private String countName;
    private List tennisAssembly;

    public Court(int countId) {
        this.countId = countId;
    }

    public String listPrice() {
        return priceList.toString();
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public String getCountName() {
        return countName;
    }

    public void setCountName(String countName) {
        this.countName = countName;
    }

    public int getCountId() {
        return countId;
    }

    public void setCountId(int countId) {
        this.countId = countId;
    }

    public List<Price> getPriceList() {
        return priceList;
    }

    public void setPriceList(List<Price> priceList) {
        this.priceList = priceList;
    }


}
