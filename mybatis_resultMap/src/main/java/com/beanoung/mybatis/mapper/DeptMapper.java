package com.beanoung.mybatis.mapper;

import com.beanoung.mybatis.pojo.Dept;
import org.apache.ibatis.annotations.Param;

public interface DeptMapper {

    //分步查询第二步
    Dept getEmpAndDeptByStepTwo(@Param("deptId") Integer deptId);

    //一对多,查询部门以及部门中的员工信息
    Dept getDeptAndEmp(@Param("deptId") Integer deptId);

    //一对多,分步查询
    Dept getDeptAndEmpByStep(@Param("deptId") Integer deptID);
}
