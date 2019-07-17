package com.noname.demo.controller;


import com.noname.demo.entity.Merchants;
import com.noname.demo.service.MerchantService;
import com.noname.demo.serviceimpl.MerchantServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@RestController
@RequestMapping("/AppMer")
public class AppMerchantController {

    @Autowired
    private MerchantService merchantService;
    /**
     * 查询所有商家
     * @return
     */
    @RequestMapping(value = "/allMer", method = RequestMethod.GET)

    private Map<String, Object> listArea(){
        Map<String, Object> map = new HashMap<>();
        List<Merchants> list = merchantService.findAllMerchant();
        map.put("listMer", list);
        return map;
    }

    /**
     * 通过商家名字搜索商家
     */
    @RequestMapping(value = "/searchMer", method = RequestMethod.GET)
    private Map<String, Object> searcMer(String name){
        Map<String, Object> map = new HashMap<>();
        Merchants merchants = null;
        map.put("Mer", merchants);
        return map;
    }
}
