package com.dinukagayashan.cryptopriceapi.application.exceptions;

import com.dinukagayashan.cryptopriceapi.domain.entities.dto.ExceptionDto;
import com.dinukagayashan.cryptopriceapi.domain.entities.dto.ResponseDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Objects;

@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(value = {ExceptionDto.class})
    public ResponseEntity<ResponseDto> handleException(ExceptionDto exceptionDto) {
        return new ResponseEntity<>(new ResponseDto(exceptionDto.getMessage(), exceptionDto.getData()), exceptionDto.getHttpStatus());
    }

    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public ResponseEntity<ResponseDto> handleValidationExceptions(MethodArgumentNotValidException methodArgumentNotValidException) {
        return new ResponseEntity<>(new ResponseDto(Objects.requireNonNull(methodArgumentNotValidException.getBindingResult().getFieldError()).getDefaultMessage(), null), methodArgumentNotValidException.getStatusCode());
    }

//    @ExceptionHandler(value = Exception.class)
//    public ResponseEntity<ResponseDto> handleAllExceptions(Exception exception){
//        log.error("generic exception");
//        return new ResponseEntity<>(new ResponseDto("generic ex",null), HttpStatus.INTERNAL_SERVER_ERROR);
//    }

}
