package com.beanoung.mybatis.mapper;

import com.beanoung.mybatis.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.Map;

public interface UserMapper {

//5种传参情况,其实可以看做两种:  1.实体类,  2.@Param

    //传单个参数
    User getUserByUsername(String username);

    //传多个参数
    User checkLogin(String username,String password);

    //传Map作为参数,就可以用自己定义的键来访问值,而不用MyBatis的
    User checkLoginByMap(Map<String,Object> map);

    //添加用户
    int insertUser(User user);

    //@Param注解    键:param的参数,值:后面的参数      就可以不用new一个map来设置键值对
    User checkLoginByParam(@Param("username") String username,@Param("password") String password);
}
