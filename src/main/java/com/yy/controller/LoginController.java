package com.yy.controller;

import com.yy.result.CodeMsg;
import com.yy.result.Result;
import com.yy.service.UserService;
import com.yy.util.ValidateUtil;
import com.yy.vo.LoginVo;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.Valid;

/**
 * Created by yy on 2018/3/3.
 */
@Controller
@RequestMapping("/login")
public class LoginController {
    private Logger logger= LoggerFactory.getLogger(LoginController.class);

    @Autowired
    UserService userService;

    @RequestMapping("/to_login")
    public String toLogin(){
        return "login";
    }

    @RequestMapping("/do_login")
    @ResponseBody
    public Result<CodeMsg> doLogin(@Valid LoginVo loginVo){
        logger.info(loginVo.toString());
        //登录
        userService.login(loginVo);
        return Result.success(CodeMsg.SUCCESS);
    }
}
