package com.noname.demo.entity;

public class Product {
    /**
    * 编号
    */
    private Integer id;

    private String ppic;

    /**
    * 菜名
    */
    private String pname;

    /**
    * 价格
    */
    private String pprice;

    /**
    * 分类ID
    */
    private Integer cateid;

    /**
    * 商店ID
    */
    private Integer mid;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPpic() {
        return ppic;
    }

    public void setPpic(String ppic) {
        this.ppic = ppic;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public String getPprice() {
        return pprice;
    }

    public void setPprice(String pprice) {
        this.pprice = pprice;
    }

    public Integer getCateid() {
        return cateid;
    }

    public void setCateid(Integer cateid) {
        this.cateid = cateid;
    }

    public Integer getMid() {
        return mid;
    }

    public void setMid(Integer mid) {
        this.mid = mid;
    }
}