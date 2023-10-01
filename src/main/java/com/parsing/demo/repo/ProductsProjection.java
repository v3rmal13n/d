package com.parsing.demo.repo;

import lombok.Data;

import java.math.BigDecimal;


public interface ProductsProjection {


    Integer getId();
    String getName();
    Integer getSubcategoryid();
    String getImagepath();
    BigDecimal getPrice();
    String getUrl();
}
