package com.yy.exception;

import com.yy.result.CodeMsg;

/**
 * Created by yy on 2018/3/22.
 */
public class GlobalException extends RuntimeException {
    private CodeMsg cm;
    public GlobalException(CodeMsg cm){
        super(cm.toString());
        this.cm=cm;
    }

    public CodeMsg getCm() {
        return cm;
    }
}
