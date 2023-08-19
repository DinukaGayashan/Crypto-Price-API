package com.dinukagayashan.cryptopriceapi.application.controller;

import com.dinukagayashan.cryptopriceapi.domain.entities.CryptocurrencyPriceId;
import com.dinukagayashan.cryptopriceapi.domain.entities.dto.CryptocurrencyPriceDto;
import com.dinukagayashan.cryptopriceapi.domain.entities.dto.ResponseDto;
import com.dinukagayashan.cryptopriceapi.domain.service.CryptocurrencyPriceService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cryptocurrencyPrice")
public class CryptocurrencyPriceController {

    @Autowired
    CryptocurrencyPriceService cryptocurrencyPriceService;

    @PostMapping("/add")
    public ResponseEntity<ResponseDto> addCryptocurrencyPrice(@Valid @RequestBody CryptocurrencyPriceDto cryptocurrencyPriceDto) throws Exception {
        return ResponseEntity.ok().body(new ResponseDto("Cryptocurrency Price Successfully Added", cryptocurrencyPriceService.addCryptocurrencyPrice(cryptocurrencyPriceDto)));
    }

    @GetMapping("/get")
    public ResponseEntity<ResponseDto> getCryptocurrencyPrice(@Valid @RequestBody CryptocurrencyPriceId cryptocurrencyPriceId) throws Exception {
        return ResponseEntity.ok().body(new ResponseDto("Cryptocurrency Price Found", cryptocurrencyPriceService.getCryptocurrencyPrice(cryptocurrencyPriceId)));
    }

}
