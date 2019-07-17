package com.noname.demo.controller;

import com.noname.demo.entity.Category;
import com.noname.demo.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/category")
public class CategoryController {
    @Autowired
    private CategoryService categoryService=null;
    @RequestMapping("/findAll")
    public List<Category> findAll()
    {
        return categoryService.findAllCate();
    }
    @RequestMapping("/insertCate")
    public int insertCate(@RequestBody Category category)
    {
        return categoryService.insertCate(category);
    }
}
