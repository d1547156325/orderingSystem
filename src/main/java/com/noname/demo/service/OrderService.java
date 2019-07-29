package com.noname.demo.service;


import com.noname.demo.entity.Orderform;
import com.noname.demo.entity.Orderformdetail;

import java.util.List;

public interface OrderService {
    public List<Orderform> findAllOrder();
    public List<Orderformdetail> findAllDetail(Integer oid);
    public List<Orderform> findAllOrderByCid(Integer cid);
    public List<Orderform> findAllByMid(Integer mid);
    public int insertOrder(Orderform orderform);
    public int insertOrderDetail(Orderformdetail orderformdetail);
    public int deleteFinished(Integer id);
    public int modifyOrder(Integer id);
}
