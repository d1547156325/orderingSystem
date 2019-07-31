package com.noname.demo.controller;

import com.noname.demo.entity.Product;
import com.noname.demo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/AppPro")
public class AppProductController {

    @Autowired
    private ProductService productService = null;

    /**
     * 商品列表
     */
    @RequestMapping(value = "/allPro", method = RequestMethod.GET)
    private Map<String, Object> listPro(){
        Map<String, Object> map = new HashMap<>();
        List<Product> list = productService.findAllProduct();
        map.put("listPro", list);
        return map;
    }

    /**
     * 根据分类id查询该分类下所有商品
     */
    @RequestMapping("/catProList")
    public Map<String, Object> searchCatPro(Integer id) {
        Map<String, Object> map = new HashMap<>();
        List<Product> list = productService.findAllByCateId(id);
        //System.out.println(id);
        map.put("listPro", list);
        map.put("success", true);
        return map;
    }

    @RequestMapping("/seaPro")
    public Map<String ,Object> findById(Integer id){
        Map<String, Object> map = new HashMap<>();
        //Product product = productService.findByPid(id);
        return map;
    }
}
