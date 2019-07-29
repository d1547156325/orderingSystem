package com.noname.demo.mapper;
import org.apache.ibatis.annotations.Param;

import com.noname.demo.entity.Productinfo;

public interface ProductinfoMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Productinfo record);

    int insertSelective(Productinfo record);

    Productinfo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Productinfo record);

    int updateByPrimaryKey(Productinfo record);

    int deleteByPid(@Param("pid")Integer pid);

    Productinfo selectOneByPid(@Param("pid")Integer pid);



}