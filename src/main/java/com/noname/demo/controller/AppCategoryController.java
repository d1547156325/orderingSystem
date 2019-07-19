package com.noname.demo.controller;

import com.noname.demo.entity.Category;
import com.noname.demo.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/AppCat")
public class AppCategoryController {

    @Autowired
    private CategoryService categoryService = null;

    /**
     * 查询所有分类
     * @return
     */
    @RequestMapping("/allCat")
    public Map<String, Object> searchAllCat(){
        List<Category> list = categoryService.findAllCate();
        Map<String, Object> map = new HashMap<>();
        map.put("allCatList", list);
        map.put("success", true);
        return map;
    }
}
