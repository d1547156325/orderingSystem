package com.noname.demo.controller;

import com.aliyuncs.dysmsapi.model.v20170525.SendSmsResponse;
import com.aliyuncs.exceptions.ClientException;
import com.noname.demo.comment.ComonUtils;
import com.noname.demo.comment.RedisOperator;
import com.noname.demo.entity.AppUserModel;
import com.noname.demo.entity.Customers;
import com.noname.demo.service.CustomerService;
import com.noname.demo.tools.AliyunSMS;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.*;

@RestController
@RequestMapping("/AppLogin")
public class AppLoginController {

    @Autowired
    CustomerService customerService = null;
    @Autowired
    RedisOperator redis = null;


    /**
     * 获取用户openid, 并将session存入redis，发送到前端
     * @param code
     * @return
     */
    @RequestMapping(value = "/doLogin", method = RequestMethod.GET)
    public Map<String, Object> appDoLogin(String code){
        Map<String, Object> map = new HashMap<>();
        if(code == null){
            map.put("success", false);
            return map;
        }
        //System.out.println(code);
        //System.out.println(new ComonUtils().appendUrl(code));
        String url = new ComonUtils().appendUrl(code).toString();
        RestTemplate restTemplate = new RestTemplate();
        String reponse = restTemplate.getForObject(url, String.class);
        if(reponse == null){
            map.put("success", false);
            return map;
        }

        System.out.println(reponse);
        String openid = "";
        String session_key = "";
        String[] strings = reponse.split(",");
        openid = strings[1].substring(10, strings[1].length()-2);
        session_key = strings[0].substring(16, strings[0].length()-1);

        AppUserModel appUserModel = new AppUserModel();
        appUserModel.setOpenid(openid);
        appUserModel.setSession_key(session_key);
        redis.set("userSession:" + appUserModel.getOpenid(), appUserModel.getSession_key(),
                60*10);
        //System.out.println(openid);
        map.put("sessionId","userSession:" + appUserModel.getOpenid());
        map.put("success", true);

        /**
         * 将openid插入数据库
         */
        String aopenid = "userSession:" + appUserModel.getOpenid();
        List<Customers> customers = customerService.findAllCustomer();
        boolean flag = false;
        for(int i = 0; i<customers.size(); i++){
            Customers customer = customers.get(i);
            if(customer.getOpenid() == null)
                continue;
            if(customer.getOpenid().equals(aopenid)){
                flag = true;
                System.out.println(true);
                break;
            }
        }

        if(!flag) {
            Customers customers1 = new Customers();
            customers1.setOpenid(aopenid);
            customerService.insertCus(customers1);
        }

        return map;
    }

    /**
     * 检测session是否过期
     */
    @RequestMapping(value = "/session", method = RequestMethod.GET)
    public Map<String, Object> doSession(String sessionId){
        String resout = redis.get(sessionId);
        Map<String, Object> map = new HashMap<>();
        if(resout == null){
            map.put("success", false);
            return map;
        }
        map.put("success", true);
        return map;
    }

    /**
     * 将session从redis中删除，实现退出账号
     */
    @RequestMapping(value = "/rvmSession",method = RequestMethod.GET)
    public Map<String, Object> removeSession(String sessionId){
        Map<String, Object> map = new HashMap<>();
        System.out.println(sessionId);
        redis.del(sessionId);
        map.put("success", true);
        return map;
    }

    /**
     * 通过openid查询手机号
     */
    @RequestMapping(value = "/searchPhone", method = RequestMethod.GET)
    public Map<String, Object> searchPhone(String openid){
        System.out.println(openid);
        Map<String, Object> map = new HashMap<>();
        Customers customer = customerService.findByOpenId(openid);
        if(customer.getCtel() == null) {
            map.put("success", false);
            System.out.println(false);
        }
        else {
            map.put("success", true);
            System.out.println(true);
            System.out.println(customer.getCtel());
        }
        return map;
    }

    /**
     * 通过openid绑定电话号码
     */
    @RequestMapping(value = "/rvmCusNum", method = RequestMethod.GET)
    public Map<String, Object> revmCustomerNumber(String openid, String phone){
        Map<String, Object> map = new HashMap<>();
        Customers customers = new Customers();
        System.out.println(phone);
        System.out.println(openid);
        if(phone == null || openid == null){
            map.put("success", false);
            return map;
        }
        customers.setOpenid(openid);
        customers.setCtel(phone);
        if(customerService.updateByOpenId(customers) != 0)
            map.put("success", true);
        else
            map.put("success", false);
        return map;
    }

    /**
     * 手机号登录注册
     */
    @RequestMapping(value = "/insertOpen", method = RequestMethod.GET)
    public Map<String, Object> insertOpenId(String code, String phone){
        Map<String, Object> map = new HashMap<>();

        /**
         * 获取openid 存入redis 发送到前端
         */
        if(code == null){
            map.put("success", false);
            return map;
        }
        //System.out.println(code);
        //System.out.println(new ComonUtils().appendUrl(code));
        String url = new ComonUtils().appendUrl(code).toString();
        RestTemplate restTemplate = new RestTemplate();
        String reponse = restTemplate.getForObject(url, String.class);
        if(reponse == null){
            map.put("success", false);
            return map;
        }

        System.out.println(reponse);
        String openid = "";
        String session_key = "";
        String[] strings = reponse.split(",");
        openid = strings[1].substring(10, strings[1].length()-2);
        session_key = strings[0].substring(16, strings[0].length()-1);

        AppUserModel appUserModel = new AppUserModel();
        appUserModel.setOpenid(openid);
        appUserModel.setSession_key(session_key);
        redis.set("userSession:" + appUserModel.getOpenid(), appUserModel.getSession_key(),
                60*10);
        //System.out.println(openid);
        map.put("sessionId","userSession:" + appUserModel.getOpenid());

        /**
         * 判断数据库中是否有此openid
         */
        List<Customers> list = customerService.findAllCustomer();
        boolean flag = false;
        for(int i = 0; i<list.size(); i++){
            Customers customer = list.get(i);
            if(customer.getOpenid().equals("userSession:" + openid)){
                flag = true;
                break;
            }
        }

        Customers customers = new Customers();
        /**
         * 如果没有 则 插入ipenid与电话号码
         */
        if(!flag) {
            customers.setOpenid("userSession:" + openid);
            customers.setCtel(phone);
            if (customerService.insertCus(customers) != 0) {
                map.put("success", true);
            } else
                map.put("success", false);
        }
        /**
         * 如果有  则更新
         */
        else {
            customers.setOpenid("userSession:" + openid);
            customers.setCtel(phone);
            if (customerService.updateByOpenId(customers) != 0) {
                map.put("success", true);
            } else
                map.put("success", false);

        }
        return map;
    }

    @RequestMapping(value = "/SMS",method = RequestMethod.GET)
    public Map<String, Object> SMS(String telephone) throws ClientException {
        Map<String, Object> map = new HashMap<>();
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
        map.put("code", code);
        return map;
    }
}
