package com.noname.demo.service;

import com.noname.demo.entity.Productinfo;
public interface ProductinfoService{


    int deleteByPrimaryKey(Integer id);

    int insert(Productinfo record);

    int insertSelective(Productinfo record);

    Productinfo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Productinfo record);

    int updateByPrimaryKey(Productinfo record);

    public Productinfo selectByPid(Integer pid);
}
