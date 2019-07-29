package com.noname.demo.service;

import com.noname.demo.entity.Customers;

import java.util.List;

public interface CustomerService {
    public List<Customers> findAllCustomer();
    public int insertCus(Customers customers);
    public int updateCus(Customers customers);
    public Customers findOneById(Integer id);
    public int updateByOpenId(Customers customers);
    public Customers findByOpenId(String openid);
}
