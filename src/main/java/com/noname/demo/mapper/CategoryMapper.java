package com.noname.demo.mapper;

import com.noname.demo.entity.Category;
import org.springframework.stereotype.Repository;

/**
 * 分类操作
 */
@Repository
public interface CategoryMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Category record);

    int insertSelective(Category record);

    Category selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Category record);

    int updateByPrimaryKey(Category record);
}