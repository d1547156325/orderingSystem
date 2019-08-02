package com.noname.demo.mapper;
import org.apache.ibatis.annotations.Param;
import com.noname.demo.entity.Customers;

import java.util.List;

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

    int updateByCtel(@Param("updated")Customers updated,@Param("ctel")String ctel);

   Customers selectOneByCtel(@Param("ctel")String ctel);

  Customers selectOneByOpenid(@Param("openid")String openid);


}