package com.noname.demo.controller;


import com.noname.demo.entity.Merchants;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@RestController
@RequestMapping("/AppMer")
public class AppMerchantController {

    /**
     * 查询所有商家
     * @return
     */
    @RequestMapping(value = "/allMer", method = RequestMethod.GET)
    private Map<String, Object> listArea(){
        Map<String, Object> map = new HashMap<>();
        List<Merchants> list = null;
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
