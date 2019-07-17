package com.noname.demo.entity;

/**
 * 管理员
 */
public class Admin {
    /**
    * 管理员ID
    */
    private Integer id;

    /**
    * 账号
    */
    private String anum;

    /**
    * 姓名
    */
    private String aname;

    /**
    * 密码
    */
    private String apassword;

    /**
    * 级别
    */
    private Integer rank;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAnum() {
        return anum;
    }

    public void setAnum(String anum) {
        this.anum = anum;
    }

    public String getAname() {
        return aname;
    }

    public void setAname(String aname) {
        this.aname = aname;
    }

    public String getApassword() {
        return apassword;
    }

    public void setApassword(String apassword) {
        this.apassword = apassword;
    }

    public Integer getRank() {
        return rank;
    }

    public void setRank(Integer rank) {
        this.rank = rank;
    }
}