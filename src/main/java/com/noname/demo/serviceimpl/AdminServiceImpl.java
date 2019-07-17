package com.noname.demo.serviceimpl;

import com.noname.demo.entity.Admin;
import com.noname.demo.mapper.AdminMapper;
import com.noname.demo.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminServiceImpl implements AdminService {
    @Autowired
    private AdminMapper adminMapper = null;

    @Override
    public Admin login(String anum, String apassword) {
       return adminMapper.findOneByAnumAndApassword(anum, apassword);
    }

    @Override
    public List<Admin> selectAllAdmin() {
        return adminMapper.findAll();
    }
}
