package com.yy.result;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Setter;

/**
 * Created by yy on 2018/1/11.
 */
@Data
@AllArgsConstructor
public class CodeMsg {
    private int code;
    private String msg;

    //通用异常
    public static CodeMsg SUCCESS=new CodeMsg(0,"success");
    public static CodeMsg SERVER_ERROR=new CodeMsg(500100,"服务端异常");
    public static CodeMsg BIND_EXCEPTION=new CodeMsg(500101,"参数校验异常：%s");


    //登录模块  5002xx
    public static CodeMsg SESSION_ERROR=new CodeMsg(500210,"Session不存在，或已经失效");
    public static CodeMsg PASSWORD_EMPTY=new CodeMsg(500211,"登录密码不能为空");
    public static CodeMsg MOBILE_EMPTY=new CodeMsg(500212,"手机号不能为空");
    public static CodeMsg MOBILE_ERROR=new CodeMsg(500213,"手机号格式错误");
    public static CodeMsg MOBILE_NOT_EXIST=new CodeMsg(500214,"手机号不存在");
    public static CodeMsg PASSWORD_ERROR=new CodeMsg(500215,"密码错误");

    //商品模块  5003xx

    //订单模块 5004xx

    //秒杀模块 5005xx


    public CodeMsg fillArgs(Object...args){
        int code=this.code;
        String msg=String.format(this.msg,args);
        return new CodeMsg(code,msg);
    }
}