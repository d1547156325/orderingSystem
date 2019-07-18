package com.noname.demo.controller;

import com.noname.demo.entity.Customers;
import com.noname.demo.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import java.util.List;

@RestController
@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    private CustomerService customerService=null;
    /*查询所有顾客*/
    @RequestMapping("/findAllCus")
    public List<Customers> findAllcus()
    {
        return customerService.findAllCustomer();
    }
    /*新增顾客*/
    @RequestMapping("/insertCus")
    public int insertCus(@RequestBody Customers customers)
    {
        return customerService.insertCus(customers);
    }
    /*更新顾客信息*/
    @RequestMapping("/updateCus")
    public int updateCus(@RequestBody Customers customers)
    {
        return customerService.updateCus(customers);
    }
    /*根据ID查找顾客*/
    @RequestMapping("/findOneById")
    public Customers findOneById(@RequestBody Integer id)
    {

        return customerService.find(id);
    }
    /*更新顾客信息*/
    @RequestMapping("/updateCus")
    public int updateCus(@RequestBody Customers customers)
    {
        return customerService.updateCus(customers);
    }
    /*根据ID查找顾客*/
    @RequestMapping("/findOneById")
    public Customers findOneById(@RequestBody Integer id)
    {
        return customerService.findOneById(id);
    }
}
