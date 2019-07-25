package com.noname.demo.controller;


import com.noname.demo.entity.Customers;
import com.noname.demo.entity.Orderform;
import com.noname.demo.service.CustomerService;
import com.noname.demo.service.OrderService;
import org.omg.CORBA.PUBLIC_MEMBER;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/AppCus")
public class AppCustomerController {


    @Autowired
    private CustomerService customerService = null;


    /**
     * 通过手机号码查询个人信息
     */

    /**
     * 通过手机号码修改个人信息
     */

    /**
     * 通过顾客id查询个人信息
     */
    @RequestMapping(value = "/CusById",method = RequestMethod.GET)
    public Map<String, Object> searchCusById(Integer id){
        Customers customers = customerService.findOneById(id);
        Map<String, Object> map = new HashMap<>();
        map.put("cusOne", customers);
        map.put("success", true);
        System.out.println("true");
        return map;
    }

    /**
     * 通过顾客id  修改顾客个人信息
     */
    @RequestMapping(value = "revCus", method = RequestMethod.POST)
    public Map<String, Object> reviseCustomer(@RequestBody Customers CusOne){
        Map<String, Object> map = new HashMap<>();
        int success = customerService.updateCus(CusOne);
        map.put("success", success);
        System.out.println("true");
        return map;
    }
}
