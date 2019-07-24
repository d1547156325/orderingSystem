package com.noname.demo.serviceimpl;

import com.noname.demo.entity.Orderform;
import com.noname.demo.entity.Orderformdetail;
import com.noname.demo.mapper.OrderformMapper;
import com.noname.demo.mapper.OrderformdetailMapper;
import com.noname.demo.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderformMapper orderformMapper=null;
    @Autowired
    private OrderformdetailMapper orderformdetailMapper=null;
    @Override
    public List<Orderform> findAllOrder() {
        return orderformMapper.selectAll();
    }

    @Override
    public List<Orderformdetail> findAllDetail(Integer oid) {
        return orderformdetailMapper.findAllByOid(oid);
    }

    @Override
    public List<Orderform> findAllOrderByCid(Integer cid) {
        return orderformMapper.findAllByCid(cid);
    }

    @Override
    public List<Orderform> findAllByMid(Integer mid) {
        return orderformMapper.findAllByMid(mid);
    }

    @Override
    public int insertOrder(Orderform orderform) {
        orderformMapper.insertSelective(orderform);
        return orderform.getId();
    }

    @Override
    public int insertOrderDetail(Orderformdetail orderformdetail) {
        return orderformdetailMapper.insertSelective(orderformdetail);
    }

    @Override
    public int deleteFinished(Integer id) {
        orderformdetailMapper.deleteByOid(id);
        return orderformMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int modifyOrder(Integer id) {
        Orderform orderform=orderformMapper.selectByPrimaryKey(id);
        orderform.setState("已完成");
        return orderformMapper.updateByPrimaryKeySelective(orderform);
    }
}
