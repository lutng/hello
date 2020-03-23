package com.coding;

import com.coding.mapper.DepartmentMapper;
import com.coding.pojo.Department;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DepartmentController {

    @Autowired
    private DepartmentMapper departmentMapper;

    @GetMapping("getDepartmentList")
    private List<Department> getDepartmentList(){
        return departmentMapper.getDepartments();
    }
}
