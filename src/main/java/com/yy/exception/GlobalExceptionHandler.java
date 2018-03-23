package com.yy.exception;

import com.yy.result.CodeMsg;
import com.yy.result.Result;
import org.springframework.validation.BindException;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by yy on 2018/3/21.
 */
@ControllerAdvice //控制器切面
@ResponseBody
public class GlobalExceptionHandler {
    @ExceptionHandler(value = Exception.class)//所有的异常都拦截
    public Result<String> exceptionHandler(HttpServletRequest request,Exception exception){
        if(exception instanceof GlobalException){
            GlobalException globalException=(GlobalException) exception;
            return Result.error(globalException.getCm());
        }else if(exception instanceof BindException){
            BindException bindException=(BindException) exception;
            List<ObjectError> errorList=bindException.getAllErrors();
            ObjectError error=errorList.get(0);
            String msg=error.getDefaultMessage();
            return Result.error(CodeMsg.BIND_EXCEPTION.fillArgs(msg));
        }else{
            return Result.error(CodeMsg.SERVER_ERROR);
        }
    }
}
