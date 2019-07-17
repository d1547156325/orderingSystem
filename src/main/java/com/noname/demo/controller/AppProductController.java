package com.noname.demo.controller;

import com.noname.demo.entity.Product;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/AppPro")
public class AppProductController {

    /**
     * 商品列表
     */
    @RequestMapping(value = "/allPro", method = RequestMethod.GET)
    private Map<String, Object> listPro(){
        Map<String, Object> map = new HashMap<>();
        List<Product> list = null;
        map.put("listPro", list);
        return map;
    }

    /**
     * 通过商家id和商品名字搜索商品
     */
    @RequestMapping(value = "/seaPro", method = RequestMethod.GET)
    private Map<String, Object> seaPro(Integer mid, String name) {
        Map<String, Object> map = new HashMap<>();
        Product product = null;
        map.put("Pro", product);
        return map;
    }
}
