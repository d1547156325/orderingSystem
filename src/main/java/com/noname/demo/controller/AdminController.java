package com.noname.demo.controller;

import com.noname.demo.service.AdminService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    private AdminService adminService=null;
    @RequestMapping("/login")
    public String login(@Param(value = "anum") String anum,@Param(value = "apassword") String apassword)
    {
             return "success";
    }
}
