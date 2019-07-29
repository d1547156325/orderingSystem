package com.noname.demo.mapper;
import org.apache.ibatis.annotations.Param;
import com.noname.demo.entity.Customers;
import org.springframework.stereotype.Repository;

import java.util.List;

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

    List<Customers> selectByCtel(@Param("ctel")String ctel);

    int updateByOpenId(@Param("updated")Customers updated,@Param("openid")String openid);

   Customers selectOneByOpenId(@Param("openid")String openid);


}