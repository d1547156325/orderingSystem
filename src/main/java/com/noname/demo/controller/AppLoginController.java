package com.noname.demo.controller;

import com.noname.demo.entity.Customers;
import com.noname.demo.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/AppLogin")
public class AppLoginController {

    @Autowired
    CustomerService customerService = null;

    @RequestMapping(value = "/doLogin", method = RequestMethod.POST)
    public Map<String, Object> appDoLogin(@RequestBody String name){
        Map<String, Object> map = new HashMap<>();
        System.out.println(name);
        return map;
    }
}
