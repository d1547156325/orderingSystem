package com.noname.demo.service;

import com.noname.demo.entity.Category;

import java.util.List;

public interface CategoryService {
    public List<Category> findAllCate();
    public int insertCate(Category category);
    public int deleteCate(Integer id);
}
