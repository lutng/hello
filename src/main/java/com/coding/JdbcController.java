package com.coding;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/jdbc")
public class JdbcController {

    // Spring的核心简化思想之一：xxxxTemplate
    // xxxxTemplate都会自动帮我们配置完毕需要的环境，拿来即用！
    @Autowired
    JdbcTemplate jdbcTemplate;

    @GetMapping("/userList")
    public List<Map<String,Object>> userList(){
        String sql = "select * from employee";
        List<Map<String, Object>> lists = jdbcTemplate.queryForList(sql);
        return lists;
    }

    // jdbcTemplate 会帮我们自动处理事务
    @GetMapping("/add")
    public String addUser(){
        String sql = "insert into employee (last_name, email, gender, department, birth)" +
                "values ('Coding','24736743@qq.com',1,101,'"+ new Date().toLocaleString() +"')";
        jdbcTemplate.update(sql);
        return "ok";
    }

    // /update/1
    @GetMapping("/update/{id}")
    public String updateUser(@PathVariable("id") int id){
        String sql = "update employee set last_name=?,email=? where id="+id;
        // 数据
        Object[] objects = new Object[2];
        objects[0] = "Coding";
        objects[1] = "222222@qq.com";

        jdbcTemplate.update(sql,objects);
        return "ok";
    }

    // 删除成功！
    @GetMapping("/delete/{id}")
    public String deleteUser(@PathVariable("id") int id){
        String sql = "delete from employee where id =?";
        jdbcTemplate.update(sql,id); //直接传递参数到sql中！
        return "ok";
    }


}
