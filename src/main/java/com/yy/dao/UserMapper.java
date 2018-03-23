package com.yy.dao;

import com.yy.domain.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * Created by yy on 2018/1/13.
 */
@Mapper
public interface UserMapper {
    @Select("select * from user where id=#{id}")
    User getById(@Param("id") long id);


}
