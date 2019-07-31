package com.noname.demo.service;

import com.noname.demo.entity.Product;
import com.noname.demo.entity.Product1;

import java.util.List;

public interface ProductService {
    public List<Product> findAllProduct();
    public int deletePro(Integer[] pros);
    public int insertPro(Product product);
    public List<Product> findAllByCateId(Integer id);
    public int deleteOntPro(Integer id);
    public Product1 findByPid(Integer pid);
    public int update(Product product);
}
