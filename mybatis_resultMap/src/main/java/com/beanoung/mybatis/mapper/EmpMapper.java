package com.beanoung.mybatis.mapper;

import com.beanoung.mybatis.pojo.Emp;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface EmpMapper {

    //通过员工id获取员工信息
    Emp getEmpById(@Param("empId") Integer empId);

    //通过员工id获取员工信息和部门信息
    Emp getEmpAndDept(@Param("empId") Integer empId);
    //分步查询第一步
    Emp getEmpAndDeptByStep(@Param("empId") Integer empId);

    //一对多,分步查询第二步
    List<Emp> getDeptAndEmpByStepTwo(@Param("deptId") Integer deptId);

}
