package com.noname.demo.controller;

import com.noname.demo.entity.Orderform;
import com.noname.demo.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderFormController {
    @Autowired
    private OrderService orderService=null;
    @RequestMapping("/findAll")
    public List<Orderform> findAll()
    {
     return orderService.findAllOrder();
    }
}
