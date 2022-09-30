package com.beanoung.mybatis.mapper;

import com.beanoung.mybatis.pojo.User;
import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface SelectMapper {

    //根据id查询
    User getUserById(@Param("id") Integer id);

    //查询所有
    List<User> getAllUser();

    //查询用户数
    Integer selectCount();

    //查询,返回map,     为什么用map: 当某个字段没有值则不会被放到map中,因此和返回实体类类型有差别
    Map<String,Object> getUserByIdToMap(@Param("id")Integer id);

    //查询,返回map,     当某个字段没有值则不会被放到map中,因此和返回实体类类型有差别
    // List<Map<String,Object>> getAllUserToMap();      //此方法用得多
    //@MapKey相当于把Map结果放在Map中,相当于两层Map,然后id作为key,子map作为value
    @MapKey("id")
    Map<String,Object> getAllUserToMap();
}
