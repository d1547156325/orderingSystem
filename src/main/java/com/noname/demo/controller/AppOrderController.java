package com.noname.demo.controller;

import com.noname.demo.entity.Customers;
import com.noname.demo.entity.Orderform;
import com.noname.demo.entity.Orderformdetail;
import com.noname.demo.service.CustomerService;
import com.noname.demo.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.*;

@RestController
@RequestMapping("/AppOrd")
public class AppOrderController {

    @Autowired
    private OrderService orderService = null;
    @Autowired
    private CustomerService customerService = null;

    /**
     * 通过openid查询该顾客所有订单
     */
    @RequestMapping("/searchOrder")
    public Map<String, Object> searchOrderByOId(String openid){
        Map<String, Object> map = new HashMap<>();
        if(openid == null){
            map.put("success", false);
            return map;
        }
        Customers customers = customerService.findByOpenId(openid);
        Integer cid = customers.getId();
        List<Orderform> list = orderService.findAllOrderByCid(cid);

        map.put("customers", customers);
        map.put("orders", list);
        map.put("success", true);
        return map;
    }

    /**
     * 通过订单状态state查询订单
     */
    @RequestMapping("/searchOrderBySta")
    public Map<String, Object> searchOrderByState(String state){
        Map<String, Object> map = new HashMap<>();
        List<Orderform> allorder=orderService.findAllOrder();
        List<Orderform> list=new ArrayList<Orderform>();
        for(int i=0;i<allorder.size();i++)
        {
            Orderform temp=allorder.get(i);
            if(temp.getState().equalsIgnoreCase(state))
                list.add(temp);
        }
        map.put("listOrder", list);

        return map;
    }

    /**
     * 购买功能 新增订单
     */
    @RequestMapping("/Buy")
    public Map<String, Object> ordBuy(Integer cId, Float totalPrice){
        Map<String , Object> map = new HashMap<>();
        Orderform orderform = new Orderform();
        orderform.setCid(cId);
        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dateString = formatter.format(date);
        orderform.setOdatetime(dateString);
        orderform.setTotalprice(totalPrice);
        orderform.setMid(1);
        orderform.setState("未完成");
        int success = orderService.insertOrder(orderform);
        map.put("success", success);
        return map;
    }

    /**
     * 通过订单id  查询订单详情
     */
    @RequestMapping(value = "/ordDetByOId", method = RequestMethod.GET)
    private Map<String , Object> orderDetailByOId(Integer Oid){
        Map<String, Object> map = new HashMap<>();
        List<Orderformdetail> list = orderService.findAllDetail(Oid);
        map.put("orderDetailList", list);
        map.put("success", true);
        return map;
    }


}
