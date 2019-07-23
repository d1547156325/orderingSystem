package com.noname.demo.controller;


import com.noname.demo.entity.Admin;
import com.noname.demo.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = "*",maxAge = 3600)
@RestController
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    private AdminService adminService=null;
    /*登录功能*/
    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public Admin  login(@RequestBody  Admin admin)
    {
        return adminService.login(admin.getAnum(),admin.getApassword());
    }
    /*查询所有管理员*/
    @RequestMapping(value = "/findAll",method = RequestMethod.GET)
    public List<Admin> findAllAdmin()
    {
        return adminService.selectAllAdmin();
    }
    /*新增管理员*/
    @RequestMapping(value = "/insertAdmin",method = RequestMethod.POST)
    public int insertAdmin(@RequestBody Admin admin)
    {
        return adminService.insertAdmin(admin);
    }
    @RequestMapping(value = "/updateAdmin",method = RequestMethod.POST)
    public int updateAdmin(@RequestBody Admin admin)
    {
        System.out.println(admin.getAnum());
        System.out.println(admin.getApassword());
        return adminService.updatePassword(admin.getAnum(),admin.getApassword());
    }
}
