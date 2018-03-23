package com.yy.util;

import org.apache.commons.lang3.StringUtils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by yy on 2018/3/9.
 */
public class ValidateUtil {

    private static final Pattern mobilePattern=Pattern.compile("1\\d{10}");

    public static boolean isMobile(String str){
        if(StringUtils.isEmpty(str)){
            return false;
        }
        Matcher matcher=mobilePattern.matcher(str);
        return matcher.matches();

    }
}
