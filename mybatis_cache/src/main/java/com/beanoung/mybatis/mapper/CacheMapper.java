package com.beanoung.mybatis.mapper;

import com.beanoung.mybatis.pojo.Emp;
import org.apache.ibatis.annotations.Param;

public interface CacheMapper {

    //根据ID查询员工信息
    Emp getEmpById(@Param("empId") Integer empId);

    //增
    void insertEmp(Emp emp);
}
