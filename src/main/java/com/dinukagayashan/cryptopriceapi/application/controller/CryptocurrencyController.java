package com.dinukagayashan.cryptopriceapi.application.controller;

import com.dinukagayashan.cryptopriceapi.domain.entities.dto.CryptocurrencyDto;
import com.dinukagayashan.cryptopriceapi.domain.service.CryptocurrencyService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/cryptocurrency")
public class CryptocurrencyController {

    @Autowired
    CryptocurrencyService cryptocurrencyService;

    @PostMapping("/add")
    public ResponseEntity<Map<String, Object>> addCryptocurrency(@Valid @RequestBody CryptocurrencyDto cryptocurrencyDto){
        cryptocurrencyService.addCryptocurrency(cryptocurrencyDto);
        return ResponseEntity.status(HttpStatus.OK).body(new HashMap<>());
    }

    @GetMapping("/get-all")
    public List<CryptocurrencyDto> getAllCryptocurrencies(){
        return cryptocurrencyService.getAllCryptocurrencies();
    }


}
