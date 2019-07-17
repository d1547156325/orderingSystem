package com.noname.demo.entity;

/**
 * 类别
 */
public class Category {
    /**
    * 分类编号
    */
    private Integer id;

    /**
    * 分类名称
    */
    private String fcategory;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFcategory() {
        return fcategory;
    }

    public void setFcategory(String fcategory) {
        this.fcategory = fcategory;
    }
}