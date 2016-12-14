package csd.starter.vo;

/**
 * Created by shushuxu on 2016/12/13.
 */
import java.util.List;
public class Count {
    private double geo;
    private List<Price> priceList;
    private int countId;

    public Count(int countId) {
        this.countId = countId;
    }

    public String listPrice() {
        return priceList.toString();
    }

    @Override
    public String toString() {
        return "Count{" +
                "geo=" + geo +
                ", priceList=" + priceList +
                ", countId=" + countId +
                '}';
    }

    public int getCountId() {
        return countId;
    }

    public void setCountId(int countId) {
        this.countId = countId;
    }



    public double getGeo() {
        return geo;
    }

    public void setGeo(double geo) {
        this.geo = geo;
    }

    public List<Price> getPriceList() {
        return priceList;
    }

    public void setPriceList(List<Price> priceList) {
        this.priceList = priceList;
    }


}
