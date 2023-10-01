package com.parsing.demo.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Objects;


@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Syn1 {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;

    @Column(name = "group")
    private int group;

    @Column(name = "word")
    private String word;

}
