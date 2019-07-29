package com.noname.demo.entity;

public class Product1 {
    private Integer id;
    private String ppic;
    private Double pprice;

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    private String comment;
    private Integer sales;
    private String fcategory;
    private Double disocunt;
    private String pname;
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

    public Double getPprice() {
        return pprice;
    }

    public void setPprice(Double pprice) {
        this.pprice = pprice;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Integer getSales() {
        return sales;
    }

    public void setSales(Integer sales) {
        this.sales = sales;
    }

    public String getFcategory() {
        return fcategory;
    }

    public void setFcategory(String fcategory) {
        this.fcategory = fcategory;
    }

    public Double getDisocunt() {
        return disocunt;
    }

    public void setDisocunt(Double disocunt) {
        this.disocunt = disocunt;
    }
}
