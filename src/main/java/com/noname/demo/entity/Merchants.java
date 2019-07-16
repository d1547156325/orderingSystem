package com.noname.demo.entity;

public class Merchants {
    /**
    * 编号
    */
    private Integer id;

    private String mpic;

    /**
    * 商家名
    */
    private String mname;

    /**
    * 联系方式
    */
    private String mtel;

    /**
    * 商家地址
    */
    private String maddress;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMpic() {
        return mpic;
    }

    public void setMpic(String mpic) {
        this.mpic = mpic;
    }

    public String getMname() {
        return mname;
    }

    public void setMname(String mname) {
        this.mname = mname;
    }

    public String getMtel() {
        return mtel;
    }

    public void setMtel(String mtel) {
        this.mtel = mtel;
    }

    public String getMaddress() {
        return maddress;
    }

    public void setMaddress(String maddress) {
        this.maddress = maddress;
    }
}