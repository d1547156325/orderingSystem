package com.noname.demo.controller;

import com.noname.demo.entity.Admin;
import com.noname.demo.service.AdminService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    private AdminService adminService=null;
    /*登录功能*/
    @RequestMapping("/login")
    public Admin login(@RequestBody Admin admin)
    {
             return adminService.login(admin.getAnum(),admin.getApassword());
    }
    /*查询所有管理员*/
    @RequestMapping("/findAll")
    public List<Admin> findAllAdmin()
    {
        return adminService.selectAllAdmin();
    }
    /*新增管理员*/
    @RequestMapping("/insertAdmin")
    public int insertAdmin(@RequestBody Admin admin)
    {
        return adminService.insertAdmin(admin);
    }
}
