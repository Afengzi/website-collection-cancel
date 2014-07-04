package com.afengzi.website.domain.user;

import java.io.Serializable;

/**
 * Created with IntelliJ IDEA.
 * User: lixiuhai
 * Date: 14-6-27
 * Time: ÏÂÎç4:51
 * To change this template use File | Settings | File Templates.
 */
public class UserInfo implements Serializable {
    private static final long serialVersionUID = -4842487603457284682L;
    private int _id;
    private String name;
    private String nickName;
    private String email;

    public int get_id() {
        return _id;
    }

    public void set_id(int _id) {
        this._id = _id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
