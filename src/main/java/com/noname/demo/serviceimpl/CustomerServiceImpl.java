package com.noname.demo.serviceimpl;

import com.noname.demo.entity.Customers;
import com.noname.demo.mapper.CustomersMapper;
import com.noname.demo.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    private CustomersMapper customersMapper=null;

    @Override
    public List<Customers> findAllCustomer() {
        return customersMapper.findAll();
    }
}
