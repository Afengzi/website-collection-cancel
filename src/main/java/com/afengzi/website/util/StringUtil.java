package com.afengzi.website.util;

import org.apache.commons.lang.StringUtils;

/**
 * Created with IntelliJ IDEA.
 * User: lixiuhai
 * Date: 14-6-11
 * Time: обнГ5:03
 * To change this template use File | Settings | File Templates.
 */
public class StringUtil extends StringUtils {

    public static String appendLogInfo(Object... objs){
        StringBuilder info = new StringBuilder();
        for(Object obj : objs){
            info.append(String.valueOf(obj));
        }
        return info.toString();
    }
}
