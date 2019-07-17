package com.noname.demo.service;


import com.noname.demo.entity.Orderform;
import com.noname.demo.entity.Orderformdetail;

import java.util.List;

public interface OrderService {
    public List<Orderform> findAllOrder();
    public List<Orderformdetail> findAllDetail(Integer oid);
    public List<Orderform> findAllOrderByCid(Integer cid);
}
