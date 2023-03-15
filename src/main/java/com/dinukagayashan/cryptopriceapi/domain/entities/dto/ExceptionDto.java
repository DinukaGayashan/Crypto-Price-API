package com.dinukagayashan.cryptopriceapi.domain.entities.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@AllArgsConstructor
@Getter
public class ExceptionResponseDto extends Exception {
    private HttpStatus httpStatus;
    private String message;
    private Object data;

}
