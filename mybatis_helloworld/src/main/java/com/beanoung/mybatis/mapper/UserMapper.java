package com.beanoung.mybatis.mapper;

import com.beanoung.mybatis.pojo.User;

import java.util.List;

public interface UserMapper {

    //增
    int insertUser();

    //改
    int updateUser();

    //删
    int deleteUser();

    //查,返回User
    User selectUser();

    //查,
    List<User> selectAllUser();

}
