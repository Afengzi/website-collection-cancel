package com.afengzi.website.domain.enumtype;

/**
 * Created with IntelliJ IDEA.
 * User: lixiuhai
 * Date: 14-7-12
 * Time: 下午12:57
 * To change this template use File | Settings | File Templates.
 */
public enum StatusEnu {
    VALID(1, "有效"), INVALID(2, "无效");
    private int code;
    private String name;

    private StatusEnu(int code, String name) {
        this.code = code;
        this.name = name;
    }

    public int getCode() {
        return code;
    }

    public String getName() {
        return name;
    }
}
