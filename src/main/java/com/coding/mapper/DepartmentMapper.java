package com.coding.mapper;

import com.coding.pojo.Department;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface DepartmentMapper {

    List<Department> getDepartments();
    Department getDepartment(Integer id);

}
