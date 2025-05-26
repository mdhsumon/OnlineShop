package com.onineshop.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResponseDTO {
    private String code;
    private String message;
    private boolean success;
    private Object data;
}
