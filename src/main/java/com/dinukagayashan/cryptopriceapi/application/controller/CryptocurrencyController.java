package com.dinukagayashan.cryptopriceapi.application.controller;

import com.dinukagayashan.cryptopriceapi.domain.entities.dto.CryptocurrencyDto;
import com.dinukagayashan.cryptopriceapi.domain.entities.dto.ResponseDto;
import com.dinukagayashan.cryptopriceapi.domain.service.CryptocurrencyService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cryptocurrency")
public class CryptocurrencyController {

    @Autowired
    CryptocurrencyService cryptocurrencyService;

    @PostMapping("/add")
    public ResponseEntity<ResponseDto> addCryptocurrency(@Valid @RequestBody CryptocurrencyDto cryptocurrencyDto) throws Exception {
        return ResponseEntity.ok().body(new ResponseDto("Cryptocurrency Successfully Added", cryptocurrencyService.addCryptocurrency(cryptocurrencyDto)));
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<ResponseDto> getCryptocurrency(@PathVariable String id) throws Exception {
        return ResponseEntity.ok().body(new ResponseDto("Cryptocurrency Found", cryptocurrencyService.getCryptocurrency(id)));
    }

    @GetMapping("/get/all")
    public ResponseEntity<ResponseDto> getAllCryptocurrencies() throws Exception {
        return ResponseEntity.ok().body(new ResponseDto("Cryptocurrencies Found", cryptocurrencyService.getAllCryptocurrencies()));
    }


}
