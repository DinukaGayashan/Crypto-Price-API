package com.dinukagayashan.cryptopriceapi.domain.entities.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ResponseDto {
    private String code;
    private String message;
    private Object data;
}
