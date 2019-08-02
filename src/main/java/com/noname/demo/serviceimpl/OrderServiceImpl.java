package com.noname.demo.serviceimpl;

import com.noname.demo.entity.OrderDetailPojo;
import com.noname.demo.entity.Orderform;
import com.noname.demo.entity.Orderformdetail;
import com.noname.demo.mapper.OrderformMapper;
import com.noname.demo.mapper.OrderformdetailMapper;
import com.noname.demo.mapper.ProductMapper;
import com.noname.demo.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderformMapper orderformMapper=null;
    @Autowired
    private OrderformdetailMapper orderformdetailMapper=null;
    @Autowired
    private ProductMapper productMapper=null;
    @Override
    public List<Orderform> findAllOrder() {
        return orderformMapper.selectAll();
    }

    @Override
    public List<OrderDetailPojo> findAllDetail(Integer oid) {
        List<Orderformdetail> orderformdetails=orderformdetailMapper.findAllByOid(oid);
        List<OrderDetailPojo> orderDetailPojos=new ArrayList<OrderDetailPojo>();
        for(int i=0;i<orderformdetails.size();i++)
        {
           OrderDetailPojo orderDetailPojo=new OrderDetailPojo();
           orderDetailPojo.setId(orderformdetails.get(i).getId());
           orderDetailPojo.setOcount(orderformdetails.get(i).getOcount());
           orderDetailPojo.setOid(orderformdetails.get(i).getOid());
           orderDetailPojo.setPname(productMapper.selectByPrimaryKey(orderformdetails.get(i).getPid()).getPname());
           orderDetailPojos.add(orderDetailPojo);
        }
        return orderDetailPojos;
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

    @Override
    public int cancelOrder(Integer id) {
        Orderform orderform=orderformMapper.selectByPrimaryKey(id);
        orderform.setState("已取消");
        return orderformMapper.updateByPrimaryKeySelective(orderform);
    }
}
