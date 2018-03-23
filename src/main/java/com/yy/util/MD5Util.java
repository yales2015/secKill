package com.yy.util;

import org.apache.commons.codec.digest.DigestUtils;

/**
 * Created by yy on 2018/3/3.
 */
public class MD5Util {

    private static String formSalt="1a2b3c4d";

    public static String md5(String str){
        return DigestUtils.md5Hex(str);
    }

    //第一次加密
    public static String inputPwdToFormPwd(String str){
        String formStr=""+formSalt.charAt(0)+formSalt.charAt(2)+str+formSalt.charAt(4)+formSalt.charAt(3);
        return md5(formStr);
    }

    //第二次加密
    public static String inputPwdToDBPwd(String str,String dbSalt){
        String dbStr=""+dbSalt.charAt(4)+dbSalt.charAt(1)+str+dbSalt.charAt(5)+dbSalt.charAt(3);
        return md5(dbStr);
    }

    //俩次MD5一起
    public static String formPwdToDBPwd(String str,String dbSalt){
        return inputPwdToDBPwd(inputPwdToFormPwd(str),dbSalt);

    }

}
