package com.noname.demo.controller;

import com.noname.demo.entity.Category;
import com.noname.demo.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = "*",maxAge = 3600)
@RestController
@RequestMapping("/category")
public class CategoryController {
    @Autowired
    private CategoryService categoryService=null;
    /*查询所有分类*/
    @RequestMapping(value = "/findAll",method = RequestMethod.GET)
    public List<Category> findAll()
    {
        return categoryService.findAllCate();
    }
    /*新增分类*/
    @RequestMapping(value = "/insertCate",method = RequestMethod.POST)
    public int insertCate(@RequestBody Category category)
    {
        return categoryService.insertCate(category);
    }
    @RequestMapping(value = "/getAllCate",method = RequestMethod.GET)
    public List<Category> getAllCate()
    {
        return categoryService.findAllCate();
    }
}
