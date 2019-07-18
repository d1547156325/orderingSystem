package com.noname.demo.controller;

import com.noname.demo.entity.Product;
import com.noname.demo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private ProductService productService=null;
    /*查询所有产品*/
    @RequestMapping("/findAllPro")
    public List<Product> findAllPro()
    {
        return productService.findAllProduct();
    }
    /*删除产品*/
    @RequestMapping("/deletePro")
    public int deletePro(@RequestBody Integer[] ids)
    {
        return productService.deletePro(ids);
    }
    /*根据分类ID查询商品*/
    @RequestMapping("/findAllByCateId")
    public List<Product> findAllByCateID(@RequestBody Integer id)
    {
        return productService.findAllByCateId(id);
    }
}
