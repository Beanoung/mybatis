package com.beanoung.mybatis.mapper;

import com.beanoung.mybatis.pojo.Emp;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface DynamicSQLMapper {

    //根据条件查询员工信息
    List<Emp> getEmpByCondition(Emp emp);

    //使用choose查询员工信息
    List<Emp> getEmpByChoose(Emp emp);

    //批量添加员工信息
    void insertMoreEmp(@Param("emps") List<Emp> emps);

    //批量删除
    void deleteMoreEmp(@Param("empIds") Integer[] empIds);
}
