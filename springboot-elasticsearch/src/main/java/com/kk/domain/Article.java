package com.kk.domain;

import io.searchbox.annotations.JestId;
import lombok.Data;

@Data
public class Article {
    @JestId
    private Integer id;
    private String name;

    public Article() {
    }

    public Article(Integer id, String name, String author, Integer price) {
        this.id = id;
        this.name = name;
        this.author = author;
        this.price = price;
    }

    private String author;
    private Integer price;



}
