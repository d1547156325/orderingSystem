package com.noname.demo.service;

import com.noname.demo.entity.Admin;

import java.util.List;

public interface AdminService {
    public Admin login(String anum, String apassword);
    public List<Admin> selectAllAdmin();
    public int insertAdmin(Admin admin);
    public int updatePassword(String anum,String apassword);
}
