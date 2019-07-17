package com.noname.demo.serviceimpl;

import com.noname.demo.entity.Merchants;
import com.noname.demo.mapper.MerchantsMapper;
import com.noname.demo.service.MerchantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MerchantServiceImpl implements MerchantService {
    @Autowired
    private MerchantsMapper merchantsMapper=null;
    @Override
    public List<Merchants> findAllMerchant() {
        return merchantsMapper.selectAll();
    }
}
