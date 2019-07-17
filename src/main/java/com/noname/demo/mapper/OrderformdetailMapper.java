package com.noname.demo.mapper;
import org.apache.ibatis.annotations.Param;
import java.util.List;

import com.noname.demo.entity.Orderformdetail;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderformdetailMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Orderformdetail record);

    int insertSelective(Orderformdetail record);

    Orderformdetail selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Orderformdetail record);

    int updateByPrimaryKey(Orderformdetail record);

    List<Orderformdetail> findAllByOid(@Param("oid")Integer oid);


}