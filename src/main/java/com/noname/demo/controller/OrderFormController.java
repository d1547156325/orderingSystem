package com.noname.demo.controller;

import com.noname.demo.entity.Customers;
import com.noname.demo.entity.Orderform;
import com.noname.demo.entity.Orderformdetail;
import com.noname.demo.service.OrderService;
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
    /*查询所有订单*/
    @RequestMapping("/findAll")
    public List<Orderform> findAll()
    {
     return orderService.findAllOrder();
    }
    /*根据订单ID查询订单详情*/
    @RequestMapping("/findDetail")
    public List<Orderformdetail> findAllDetail(@RequestBody Orderform orderform)
    {
        return orderService.findAllDetail(orderform.getId());
    }
    /*通过顾客ID查询订单*/
    @RequestMapping("/findOrderByCid")
    public List<Orderform> findAllOrderByCid(@RequestBody Customers customers)
    {
        return orderService.findAllOrderByCid(customers.getId());
    }
    /*根据商户ID查询订单*/
    @RequestMapping("/findAllByMid")
    public List<Orderform> findAllByMid(@RequestBody Integer id)
    {
        return orderService.findAllByMid(id);
    }
    /*插入新的订单*/
    @RequestMapping("/insertOrder")
    public int insertOrder(@RequestBody Orderform orderform)
    {
        return orderService.insertOrder(orderform);
    }
}
