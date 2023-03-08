package com.dinukagayashan.cryptopriceapi.application.controller;

import com.dinukagayashan.cryptopriceapi.domain.entities.Cryptocurrency;
import com.dinukagayashan.cryptopriceapi.domain.entities.dto.CryptocurrencyDto;
import com.dinukagayashan.cryptopriceapi.domain.service.CryptocurrencyService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cryptocurrency")
public class CryptocurrencyController {

    @Autowired
    CryptocurrencyService cryptocurrencyService;

    @PostMapping("/add")
    public ResponseEntity<Cryptocurrency> addCryptocurrency(@Valid @RequestBody CryptocurrencyDto cryptocurrencyDto){
        return new ResponseEntity<Cryptocurrency>(cryptocurrencyService.addCryptocurrency(cryptocurrencyDto), HttpStatus.CREATED);
    }

}
