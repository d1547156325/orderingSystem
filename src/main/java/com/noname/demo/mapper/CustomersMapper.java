package com.noname.demo.mapper;
import org.apache.ibatis.annotations.Param;
import java.util.List;

import com.noname.demo.entity.Customers;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomersMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Customers record);

    int insertSelective(Customers record);

    Customers selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Customers record);

    int updateByPrimaryKey(Customers record);

    List<Customers> findAll();

    Customers findOneById(@Param("id")Integer id);


}