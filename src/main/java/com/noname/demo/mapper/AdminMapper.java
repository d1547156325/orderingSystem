package com.noname.demo.mapper;
import com.noname.demo.entity.Admin;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AdminMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Admin record);

    int insertSelective(Admin record);

    Admin selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Admin record);

    int updateByPrimaryKey(Admin record);

   Admin findOneByAnumAndApassword(@Param("anum")String anum,@Param("apassword")String apassword);

   List<Admin> findAll();

  Admin findOneByAnum(@Param("anum")String anum);

    int updateByAnumAndApassword(@Param("updated")Admin updated,@Param("anum")String anum,@Param("apassword")String apassword);

    Admin selectOneByAnum(@Param("anum")String anum);


}