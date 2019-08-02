package com.noname.demo.serviceimpl;

import com.noname.demo.entity.Productinfo;
import com.noname.demo.mapper.ProductinfoMapper;
import com.noname.demo.service.ProductinfoService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
@Service
public class ProductinfoServiceImpl implements ProductinfoService{

    @Resource
    private ProductinfoMapper productinfoMapper;

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return productinfoMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(Productinfo record) {
        return productinfoMapper.insert(record);
    }

    @Override
    public int insertSelective(Productinfo record) {
        return productinfoMapper.insertSelective(record);
    }

    @Override
    public Productinfo selectByPrimaryKey(Integer id) {
        return productinfoMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(Productinfo record) {
        return productinfoMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Productinfo record) {
        return productinfoMapper.updateByPrimaryKey(record);
    }

    @Override
    public Productinfo selectByPid(Integer pid) {
        return productinfoMapper.selectOneByPid(pid);
    }

}
