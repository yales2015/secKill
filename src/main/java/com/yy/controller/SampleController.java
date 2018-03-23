package com.yy.controller;
/**
 * Created by yy on 2018/1/11.
 */

import com.yy.redis.RedisService;
import com.yy.redis.UserKey;
import com.yy.result.CodeMsg;
import com.yy.result.Result;
import com.yy.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.*;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/test")
public class SampleController {
    @Autowired
    UserService userService;

    @Autowired
    RedisService redisService;

    @RequestMapping("/error")
    @ResponseBody
    Result<String> error() {
        return Result.error(CodeMsg.SERVER_ERROR);
    }

    @RequestMapping("/db/get")
    @ResponseBody
    Result<String> dbGet() {
        return Result.success(userService.getById((long)1).toString());
    }

    @RequestMapping("/hello")
    String thymleaf(Model model) {
        model.addAttribute("name","yy");
        return "hello";
    }


    @RequestMapping("/redis/get")
    @ResponseBody
    Result<Long> redisGet() {
        Long v1=redisService.get(UserKey.getById,"1",long.class);
        return Result.success(v1);
    }

    @RequestMapping("/redis/set")
    @ResponseBody
    Result<String> redisSet() {
        redisService.set(UserKey.getById,"2","hello,yy");
        String v2=redisService.get(UserKey.getById,"2",String.class);
        return Result.success(v2);
    }
}
