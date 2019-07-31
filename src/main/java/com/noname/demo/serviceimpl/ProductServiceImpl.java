package com.noname.demo.serviceimpl;

import com.noname.demo.entity.*;
import com.noname.demo.mapper.CategoryMapper;
import com.noname.demo.mapper.ProductMapper;
import com.noname.demo.mapper.ProductinfoMapper;
import com.noname.demo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductMapper productMapper=null;
    @Autowired
    private ProductinfoMapper productinfoMapper=null;
    @Autowired
    private CategoryMapper categoryMapper=null;
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

    @Override
    public int deleteOntPro(Integer id) {
        productMapper.deleteByPrimaryKey(id);
        return productinfoMapper.deleteByPid(id);
    }

    @Override
    public Product1 findByPid(Integer pid) {
       Product1 product1=new Product1();
       Product product=productMapper.selectByPrimaryKey(pid);
       Productinfo productinfo=productinfoMapper.selectOneByPid(pid);
       Category category=categoryMapper.selectByPrimaryKey(product.getCateid());
        product1.setId(product.getId());
        product1.setComment(productinfo.getComment());
        product1.setDisocunt(productinfo.getDisocunt());
        product1.setFcategory(category.getFcategory());
        product1.setPpic(product.getPpic());
        product1.setPprice(product.getPprice());
        product1.setPname(product.getPname());
        product1.setSales(productinfo.getSales());
        return product1;
    }

    @Override
    public int update(Product product) {
        return productMapper.updateByPrimaryKeySelective(product);
    }

    @Override
    public Product findTempById(Integer id) {
    return productMapper.selectByPrimaryKey(id);
    }

}