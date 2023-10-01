package com.parsing.demo.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class ProductDTO {
    private int id;
    private String name;
    private int categoryid;
    private String imagepath;
    private BigDecimal price;
    private String url;

    public ProductDTO(int id, String name, int categoryid, String imagepath, BigDecimal price, String url) {
        this.id = id;
        this.name = name;
        this.categoryid = categoryid;
        this.imagepath = imagepath;
        this.price = price;
        this.url = url;
    }
}
