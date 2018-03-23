package com.yy.service;

import com.yy.dao.UserMapper;
import com.yy.domain.User;
import com.yy.exception.GlobalException;
import com.yy.result.CodeMsg;
import com.yy.util.MD5Util;
import com.yy.vo.LoginVo;
import org.apache.commons.codec.binary.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by yy on 2018/1/13.
 */
@Service
public class UserService {
    @Autowired
    UserMapper userDao;

    public User getById(Long id){
        return userDao.getById(id);
    }

    public boolean login(LoginVo loginVo) {
        if(loginVo==null){
            throw new GlobalException(CodeMsg.SERVER_ERROR);
        }
        String mobile=loginVo.getMobile();
        String formPassword=loginVo.getPassword();;
        //判断手机号是否存在
        User user=getById(Long.parseLong(mobile));
        if (user == null) {
            throw new GlobalException(CodeMsg.MOBILE_NOT_EXIST);
        }
        String dbPassword=user.getPassword();
        String salt=user.getSalt();
        String calcPassword=MD5Util.formPwdToDBPwd(formPassword,salt);
        if(!StringUtils.equals(dbPassword,calcPassword)){
            throw new GlobalException(CodeMsg.PASSWORD_ERROR);
        }
        return true;
    }
}
