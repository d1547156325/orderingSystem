package com.noname.demo.controller;


import com.aliyuncs.dysmsapi.model.v20170525.SendSmsResponse;
import com.aliyuncs.exceptions.ClientException;
import com.noname.demo.entity.Admin;
import com.noname.demo.service.AdminService;
import com.noname.demo.tools.AliyunSMS;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;
@CrossOrigin(origins = "*",maxAge = 3600)
@RestController
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    private AdminService adminService=null;
    /*登录功能*/
    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public Admin  login(@RequestBody  Admin admin, HttpSession session)
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
        return adminService.updatePassword(admin.getAnum(),admin.getApassword());
    }
    @RequestMapping(value = "/SMSVerification",method = RequestMethod.POST)
    public String SMSVerification( String telephone) throws ClientException {
        System.out.println(telephone);
        AliyunSMS.setNewcode();
        String code = Integer.toString(AliyunSMS.getNewcode());
        System.out.println("发送的验证码为："+code);
        //发短信t
        SendSmsResponse response =AliyunSMS.sendSms(telephone,code); // TODO 填写你需要测试的手机号码
        System.out.println("短信接口返回的数据----------------");
        System.out.println("Code=" + response.getCode());
        System.out.println("Message=" + response.getMessage());
        System.out.println("RequestId=" + response.getRequestId());
        System.out.println("BizId=" + response.getBizId());
        return code;
    }
}
