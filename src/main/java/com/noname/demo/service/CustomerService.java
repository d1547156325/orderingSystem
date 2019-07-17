package com.noname.demo.service;

import com.noname.demo.entity.Customers;

import java.util.List;

public interface CustomerService {
    public List<Customers> findAllCustomer();
    public int insertCus(Customers customers);
}
