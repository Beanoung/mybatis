package com.beanoung.mybatis.mapper;

import com.beanoung.mybatis.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 特殊SQL查询,#{}就不能完成,需使用${}
 */
public interface SpecialSQLMapper {

    // 模糊查询,通过用户名
    List<User> getUserByLike(@Param("mohu") String mohu);

    //批量删除
    int deleteMoreUser(@Param("ids") String ids);

    //动态设置表名,查询用户信息
    List<User> getUserList(@Param("tableName") String tableName);

    //添加用户信息,并获得自增的主键
    void insertUser(User user);

}
