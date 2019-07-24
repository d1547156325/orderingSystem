package com.noname.demo.mapper;
import com.noname.demo.entity.Orderformdetail;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderformdetailMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Orderformdetail record);

    int insertSelective(Orderformdetail record);

    Orderformdetail selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Orderformdetail record);

    int updateByPrimaryKey(Orderformdetail record);

    List<Orderformdetail> findAllByOid(@Param("oid")Integer oid);

     int deleteByOid(@Param("oid")Integer oid);


}