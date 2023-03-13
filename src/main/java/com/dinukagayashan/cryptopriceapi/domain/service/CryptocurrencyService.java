package com.dinukagayashan.cryptopriceapi.domain.service;

import com.dinukagayashan.cryptopriceapi.domain.entities.Cryptocurrency;
import com.dinukagayashan.cryptopriceapi.domain.entities.dto.CryptocurrencyDto;

import java.util.List;

public interface CryptocurrencyService {
    Cryptocurrency addCryptocurrency(CryptocurrencyDto cryptocurrencyDto) throws Exception;
    List<CryptocurrencyDto> getAllCryptocurrencies();
}
