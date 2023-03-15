package com.dinukagayashan.cryptopriceapi.application.exceptions;

import com.dinukagayashan.cryptopriceapi.domain.entities.dto.ResponseDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;

@ControllerAdvice
public class ExceptionHandler {

    public ResponseEntity<ResponseDto> handleException(ExceptionResponse exceptionResponse){
        return new ResponseEntity<>(new ResponseDto(exceptionResponse.getMessage(),exceptionResponse.getData()),exceptionResponse.getHttpStatus());
    }
}
