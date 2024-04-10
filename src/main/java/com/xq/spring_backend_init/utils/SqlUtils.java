package com.xq.spring_backend_init.utils;


import org.apache.commons.lang3.StringUtils;

public class SqlUtils {

    /**
     * 校验sql是否合法
     */

    public static boolean validSortField(String sortField){
        if(StringUtils.isBlank(sortField)){
            return false;
        }
        return !StringUtils.containsAny(sortField, "=", "(", ")", " ");
    }

}
