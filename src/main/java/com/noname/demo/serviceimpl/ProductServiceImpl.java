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

    @Override
    public int deletePro(Integer[] ids) {
        int sum=ids.length;
        for(Integer temp:ids)
        {
            productMapper.deleteById(temp);
        }
        return sum;
    }

    @Override
    public int insertPro(Product product) {
         productMapper.insertSelective(product);
         return product.getId();
    }

    @Override
    public List<Product> findAllByCateId(Integer id) {

        return productMapper.selectAllByCateid(id);
    }
}