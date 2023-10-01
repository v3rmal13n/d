package com.parsing.demo.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Objects;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Product {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "categoryid")
    private int categoryid;

    @Column(name = "imagepath")
    private String imagepath;

    @Column(name = "price")
    private BigDecimal price;

    @Column(name = "url")
    private String url;

    @Column(name = "vendorid")
    private int vendorid;

    @Column(name = "rating")
    private BigDecimal rating;

    @Column(name = "ratingcount")
    private Long ratingcount;

    @Column(name = "desc")
    private String desc;

    @Column(name = "metaid")
    private int metaid;

}
