package com.onineshop.dtos;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
public class ProductDTO {
    private Integer id;
    private String name;
    private String description;
    private Double price;
    private String image;
    private Integer status;
    private Integer categoryId;
    private String createdAt;
    private String updatedAt;
}
