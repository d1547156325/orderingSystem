package com.noname.demo.controller;

import com.noname.demo.entity.Orderform;
import com.noname.demo.entity.Orderformdetail;
import com.noname.demo.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/AppOrd")
public class AppOrderController {

    @Autowired
    private OrderService orderService = null;

    /**
     * 通过顾客id查询该顾客所有订单
     */
    @RequestMapping("/OrderById")
    public Map<String, Object> findOneById(@RequestBody Integer id)
    {
        List<Orderform> list = orderService.findAllOrderByCid(id);
        Map<String, Object> map = new HashMap<>();
        map.put("orderCList", list);
        map.put("success", true);
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
