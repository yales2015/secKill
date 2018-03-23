package com.yy.result;

import com.sun.org.apache.bcel.internal.classfile.Code;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Setter;

/**
 * Created by yy on 2018/1/11.
 */
@Data
@AllArgsConstructor
public class Result<T>{
    private int code;
    private String msg;
    private T data;

    private Result(T data){
        this.code=0;
        this.msg="success";
        this.data=data;
    }
    private Result(CodeMsg cm){
        if(cm==null){
            return;
        }
        this.code=cm.getCode();
        this.msg=cm.getMsg();
    }

    public static<T> Result<T> success(T data){
        return new Result<T>(data);
    }

    public static<T> Result<T> error(CodeMsg cm){
        return new Result<T>(cm);
    }
}
