package com.noname.demo.controller;

import com.noname.demo.entity.Customers;
import com.noname.demo.entity.Orderform;
import com.noname.demo.entity.OrderformNofinish;
import com.noname.demo.entity.Orderformdetail;
import com.noname.demo.service.CustomerService;
import com.noname.demo.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
@CrossOrigin(origins = "*",maxAge = 3600)
@RestController
@RequestMapping("/order")
public class OrderFormController {
    @Autowired
    private OrderService orderService=null;
    @Autowired
    private CustomerService customerService=null;
    /*查询所有已完成订单*/
    @RequestMapping(value = "/findAll",method = RequestMethod.GET)
    public List<Orderform> findAll()
    {
        List<Orderform> allorder=orderService.findAllOrder();
        List<Orderform> finished=new ArrayList<Orderform>();
        for(int i=0;i<allorder.size();i++)
        {
            Orderform temp=allorder.get(i);
            if(temp.getState().equalsIgnoreCase("已完成"))
                finished.add(temp);
        }
        return finished;
    }
    @RequestMapping(value = "/NoFinishedOrder",method = RequestMethod.GET)
    public List<OrderformNofinish>  getAllNoFinished()
    {
        List<Orderform> allorder=orderService.findAllOrder();
        List<Orderform> finished=new ArrayList<Orderform>();
        for(int i=0;i<allorder.size();i++)
        {
            Orderform temp=allorder.get(i);
            if(temp.getState().equalsIgnoreCase("未完成"))
                finished.add(temp);
        }
        List<Customers> customers=new ArrayList<Customers>();
        for(int i=0;i<finished.size();i++)
        {
            Orderform temp=allorder.get(i);
            customers.add(customerService.findOneById(temp.getCid()));
        }
        List<OrderformNofinish> orderformNofinishes=new ArrayList<OrderformNofinish>();
        for(int i=0;i<finished.size();i++)
        {
            OrderformNofinish temp2=new OrderformNofinish();
            temp2.setId(finished.get(i).getId());
            temp2.setCname(customers.get(i).getCname());
            temp2.setCaddress(customers.get(i).getCaddress());
            temp2.setCtel(customers.get(i).getCtel());
            temp2.setOdatetime(finished.get(i).getOdatetime());
            temp2.setTotalprice(finished.get(i).getTotalprice());
            orderformNofinishes.add(temp2);
        }
        return orderformNofinishes;

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
