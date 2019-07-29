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

    @Override
    public int insertCus(Customers customers) {
        return customersMapper.insertSelective(customers);
    }

    @Override
    public int updateCus(Customers customers) {
        return customersMapper.updateByPrimaryKeySelective(customers);
    }

    @Override
    public Customers findOneById(Integer id) {
        return customersMapper.findOneById(id);
    }

    @Override
    public int updateByCtel(Customers customers) {
     return customersMapper.updateByCtel(customers,customers.getCtel());
    }

    @Override
    public Customers findByCtel(String ctel) {
       return customersMapper.selectOneByCtel(ctel);
    }

}
