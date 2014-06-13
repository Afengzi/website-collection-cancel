package com.afengzi.website.domain.site.techonlogy;

/**
 * Created with IntelliJ IDEA.
 * User: lixiuhai
 * Date: 14-6-13
 * Time: обнГ5:35
 * To change this template use File | Settings | File Templates.
 */
public class TechnologyQuery {
    private String userPin ;
    private int type ;

    public void setUserPin(String userPin) {
        this.userPin = userPin;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getUserPin() {
        return userPin;
    }

    public int getType() {
        return type;
    }
}
