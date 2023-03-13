package com.dinukagayashan.cryptopriceapi.application.controller;

import com.dinukagayashan.cryptopriceapi.domain.entities.dto.CryptocurrencyDto;
import com.dinukagayashan.cryptopriceapi.domain.entities.dto.ResponseDto;
import com.dinukagayashan.cryptopriceapi.domain.service.CryptocurrencyService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cryptocurrency")
public class CryptocurrencyController {

    @Autowired
    CryptocurrencyService cryptocurrencyService;

    @PostMapping("/add")
    public ResponseEntity<ResponseDto> addCryptocurrency(@Valid @RequestBody CryptocurrencyDto cryptocurrencyDto) throws Exception{
        return ResponseEntity.ok().body(new ResponseDto("201","Cryptocurrency Successfully Added", cryptocurrencyService.addCryptocurrency(cryptocurrencyDto)));
    }

    @GetMapping("/get-all")
    public List<CryptocurrencyDto> getAllCryptocurrencies(){
        return cryptocurrencyService.getAllCryptocurrencies();
    }


}
