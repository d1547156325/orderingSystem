package com.noname.demo.mapper;

import com.noname.demo.entity.Merchants;
import org.springframework.stereotype.Repository;

/**
 * 商家操作
 */
@Repository
public interface MerchantsMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Merchants record);

    int insertSelective(Merchants record);

    Merchants selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Merchants record);

    int updateByPrimaryKey(Merchants record);

}