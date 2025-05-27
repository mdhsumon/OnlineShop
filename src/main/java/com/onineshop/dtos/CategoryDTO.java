package com.onineshop.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CategoryDTO {
    private Integer id;
    private String name;
    private String description;
    private Integer status;
    private String createdAt;
    private String updatedAt;
}
