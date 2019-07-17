package com.noname.demo.controller;

import com.noname.demo.entity.Customers;
import com.noname.demo.entity.Orderform;
import com.noname.demo.entity.Orderformdetail;
import com.noname.demo.service.OrderService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
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
    @RequestMapping("/findDetail")
    public List<Orderformdetail> findAllDetail(@RequestBody Orderform orderform)
    {
        return orderService.findAllDetail(orderform.getId());
    }
    @RequestMapping("/findOrderByCid")
    public List<Orderform> findAllOrderByCid(@RequestBody Customers customers)
    {
        return orderService.findAllOrderByCid(customers.getId());
    }
}
