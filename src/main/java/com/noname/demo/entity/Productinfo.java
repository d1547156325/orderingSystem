package com.noname.demo.entity;

public class Productinfo {
    private Integer id;

    private Integer pid;

    private String comment;

    private Integer sales;

    private Double disocunt;

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

    public Double getDisocunt() {
        return disocunt;
    }

    public void setDisocunt(Double disocunt) {
        this.disocunt = disocunt;
    }
}