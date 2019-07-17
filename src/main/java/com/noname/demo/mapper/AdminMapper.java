package com.noname.demo.mapper;

import com.noname.demo.entity.Admin;
import org.springframework.stereotype.Repository;

/**
 * 管理员操作
 */
@Repository
public interface AdminMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Admin record);

    int insertSelective(Admin record);

    Admin selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Admin record);

    int updateByPrimaryKey(Admin record);

}