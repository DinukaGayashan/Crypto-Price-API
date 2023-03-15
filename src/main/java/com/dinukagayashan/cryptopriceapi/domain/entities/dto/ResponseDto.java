package com.dinukagayashan.cryptopriceapi.domain.entities.dto;

import lombok.Data;

import java.time.ZoneId;
import java.time.ZonedDateTime;

@Data
public class ResponseDto {
    ZonedDateTime timestamp = ZonedDateTime.now(ZoneId.of("Z"));
    private String message;
    private Object data;

    public ResponseDto(String message, Object data) {
        this.message=message;
        this.data=data;
    }
}
