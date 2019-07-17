package com.noname.demo.mapper;

import com.noname.demo.entity.Remark;

public interface RemarkMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Remark record);

    int insertSelective(Remark record);

    Remark selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Remark record);

    int updateByPrimaryKey(Remark record);

}