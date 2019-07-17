package com.noname.demo.serviceimpl;

import com.noname.demo.entity.Product;
import com.noname.demo.mapper.ProductMapper;
import com.noname.demo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductMapper productMapper=null;
    @Override
    public List<Product> findAllProduct() {
        return productMapper.findAll();
    }
}

