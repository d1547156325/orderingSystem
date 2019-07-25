package com.noname.demo.entity;

public class Customers {
    /**
    * 客户ID
    */
    private Integer id;

    /**
    * 客户姓名
    */
    private String cname;

    /**
    * 客户性别
    */
    private String sex;

    /**
    * 联系方式
    */
    private String ctel;

    /**
    * 地址
    */
    private String caddress;

    private String openid;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getCtel() {
        return ctel;
    }

    public void setCtel(String ctel) {
        this.ctel = ctel;
    }

    public String getCaddress() {
        return caddress;
    }

    public void setCaddress(String caddress) {
        this.caddress = caddress;
    }

    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid;
    }
}