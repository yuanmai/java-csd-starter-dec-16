package csd.starter.vo;

/**
 * Created by shushuxu on 2016/12/13.
 */
public class Player {
    private String userName;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Player(String userName) {
        this.userName = userName;
    }
}
