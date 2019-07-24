package com.noname.demo.entity;

public class Orderform {
    /**
    * 订单ID
    */
    private Integer id;

    /**
    * 客户ID
    */
    private Integer cid;

    /**
    * 总金额
    */
    private Float totalprice;

    /**
    * 商家ID
    */
    private Integer mid;

    /**
    * 销售时间
    */
    private String odatetime;

    /**
    * 订单状态
    */
    private String state;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    public Float getTotalprice() {
        return totalprice;
    }

    public void setTotalprice(Float totalprice) {
        this.totalprice = totalprice;
    }

    public Integer getMid() {
        return mid;
    }

    public void setMid(Integer mid) {
        this.mid = mid;
    }

    public String getOdatetime() {
        return odatetime;
    }

    public void setOdatetime(String odatetime) {
        this.odatetime = odatetime;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}