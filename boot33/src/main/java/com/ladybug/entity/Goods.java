package com.ladybug.entity;

import org.springframework.format.annotation.DateTimeFormat;

public class Goods {
    private Integer id;
    private String picture;
    private String goodsName;
    private String productDate;

    @Override
    public String toString() {
        return "Goods{" +
                "id=" + id +
                ", picture='" + picture + '\'' +
                ", goodsName='" + goodsName + '\'' +
                ", productDate='" + productDate + '\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public String getProductDate() {
        return productDate;
    }

    public void setProductDate(String productDate) {
        this.productDate = productDate;
    }
}
