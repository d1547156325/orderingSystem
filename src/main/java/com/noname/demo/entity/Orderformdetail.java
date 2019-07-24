package com.noname.demo.entity;

/**
 * 订单明细
 */
public class Orderformdetail {
    /**
    * 编号
    */
    private Integer id;

    /**
    * 产品ID
    */
    private Integer pid;

    /**
    * 数量
    */
    private Integer ocount;

    /**
    * 订单ID
    */
    private Integer oid;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public Integer getOcount() {
        return ocount;
    }

    public void setOcount(Integer ocount) {
        this.ocount = ocount;
    }

    public Integer getOid() {
        return oid;
    }

    public void setOid(Integer oid) {
        this.oid = oid;
    }
}