package com.noname.demo.serviceimpl;

import com.noname.demo.entity.Orderform;
import com.noname.demo.mapper.OrderformMapper;
import com.noname.demo.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderformMapper orderformMapper=null;
    @Override
    public List<Orderform> findAllOrder() {
        return orderformMapper.selectAll();
    }
}
