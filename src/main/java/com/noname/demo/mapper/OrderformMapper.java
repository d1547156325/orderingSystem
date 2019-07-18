package com.noname.demo.mapper;
import org.apache.ibatis.annotations.Param;

import com.noname.demo.entity.Orderform;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderformMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Orderform record);

    int insertSelective(Orderform record);

    Orderform selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Orderform record);

    int updateByPrimaryKey(Orderform record);

    List<Orderform> selectAll();

    List<Orderform> findAllByCid(@Param("cid")Integer cid);

    List<Orderform> findAllByMid(@Param("mid")Integer mid);

}