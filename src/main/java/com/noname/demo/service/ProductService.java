package com.noname.demo.service;

import com.noname.demo.entity.Product;

import java.util.List;

public interface ProductService {
    public List<Product> findAllProduct();
    public int deletePro(Integer[] pros);
    public int insertPro(Product product);
    public List<Product> findAllByCateId(Integer id);
}
