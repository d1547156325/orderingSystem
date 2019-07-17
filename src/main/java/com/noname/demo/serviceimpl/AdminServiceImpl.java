package com.noname.demo.serviceimpl;

import com.noname.demo.mapper.AdminMapper;
import com.noname.demo.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminServiceImpl implements AdminService {
    @Autowired
    private AdminMapper adminMapper=null;
    @Override
    public String login(String anum, String apassword) {
          return "success";
    }
}
