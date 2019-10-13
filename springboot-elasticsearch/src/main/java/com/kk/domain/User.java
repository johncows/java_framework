package com.kk.domain;

import lombok.Data;
import org.springframework.data.elasticsearch.annotations.Document;

@Data
@Document(indexName = "kk",type = "book")
public class User {
    private Integer id;
    private String name;
}
