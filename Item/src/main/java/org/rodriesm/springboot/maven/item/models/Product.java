package org.rodriesm.springboot.maven.item.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product {

    private Long id;
    private Integer port;
    private String name;
    private Double price;
    private Date create_at;
}
