package com.noname.demo.controller;

import com.noname.demo.entity.Customers;
import com.noname.demo.entity.Orderform;
import com.noname.demo.entity.Orderformdetail;
import com.noname.demo.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = "*",maxAge = 3600)
@RestController
@RequestMapping("/order")
public class OrderFormController {
    @Autowired
    private OrderService orderService=null;
    /*查询所有订单*/
    @RequestMapping(value = "/findAll",method = RequestMethod.GET)
    public List<Orderform> findAll()
    {
     return orderService.findAllOrder();
    }
    /*根据订单ID查询订单详情*/
    @RequestMapping(value = "/findDetail",method = RequestMethod.POST)
    public List<Orderformdetail> findAllDetail(@RequestBody Orderform orderform)
    {
        return orderService.findAllDetail(orderform.getId());
    }
    /*通过顾客ID查询订单*/
    @RequestMapping(value = "/findOrderByCid",method = RequestMethod.POST)
    public List<Orderform> findAllOrderByCid(@RequestBody Customers customers)
    {
        return orderService.findAllOrderByCid(customers.getId());
    }
    /*根据商户ID查询订单*/
    @RequestMapping(value = "/findAllByMid",method = RequestMethod.POST)
    public List<Orderform> findAllByMid(@RequestBody Integer id)
    {
        return orderService.findAllByMid(id);
    }
    /*插入新的订单*/
    @RequestMapping(value = "/insertOrder",method = RequestMethod.POST)
    public int insertOrder(@RequestBody Orderform orderform)
    {
        return orderService.insertOrder(orderform);
    }
}
