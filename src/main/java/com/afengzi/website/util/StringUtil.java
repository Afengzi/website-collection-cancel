package com.afengzi.website.util;

import org.apache.commons.lang.StringUtils;

/**
 * Created by IntelliJ IDEA. User: zt Date: 2011-6-1 Time: 15:37:45
 */
public class StringUtil extends StringUtils {
    /**
     * 组织日志内容,注意参数顺序
     * @param infos
     * @return
     */
    public static String appendLogstr(Object... infos){
        StringBuilder log = new StringBuilder() ;
        for(Object info : infos){
             log.append(String.valueOf(info)) ;
        }
        return log.toString();
    }
}
