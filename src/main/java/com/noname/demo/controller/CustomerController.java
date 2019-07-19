package com.noname.demo.controller;

import com.noname.demo.entity.Customers;
import com.noname.demo.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.List;
@CrossOrigin(origins = "*",maxAge = 3600)
@RestController
@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    private CustomerService customerService=null;
    /*查询所有顾客*/
    @RequestMapping(value = "/findAllCus",method = RequestMethod.GET)
    public List<Customers> findAllcus()
    {
        return customerService.findAllCustomer();
    }
    /*新增顾客*/
    @RequestMapping(value = "/insertCus",method = RequestMethod.POST)
    public int insertCus(@RequestBody Customers customers)
    {
        return customerService.insertCus(customers);
    }
    /*更新顾客信息*/
    @RequestMapping(value = "/updateCus",method = RequestMethod.POST)
    public int updateCus(@RequestBody Customers customers)
    {

        return customerService.updateCus(customers);
    }
    /*根据ID查找顾客*/
    @RequestMapping(value = "/findOneById",method = RequestMethod.POST)
    public Customers findOneById(@RequestBody Integer id)
    {

        return customerService.findOneById(id);
    }
}
