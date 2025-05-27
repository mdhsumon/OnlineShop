package com.onineshop.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderDTO {
    private Integer id;
    private Integer productId;
    private String customerName;
    private String customerEmail;
    private String customerPhone;
    private String customerAddress;
    private Integer paymentMethod;
    private Integer status;
    private String createdAt;
    private String updatedAt;
}
