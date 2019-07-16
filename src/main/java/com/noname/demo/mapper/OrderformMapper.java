package com.noname.demo.mapper;

import com.noname.demo.entity.Orderform;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderformMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Orderform record);

    int insertSelective(Orderform record);

    Orderform selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Orderform record);

    int updateByPrimaryKey(Orderform record);
}