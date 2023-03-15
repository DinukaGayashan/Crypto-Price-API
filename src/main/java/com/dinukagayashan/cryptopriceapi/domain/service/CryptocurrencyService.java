package com.dinukagayashan.cryptopriceapi.domain.service;

import com.dinukagayashan.cryptopriceapi.domain.entities.Cryptocurrency;
import com.dinukagayashan.cryptopriceapi.domain.entities.dto.CryptocurrencyDto;
import com.dinukagayashan.cryptopriceapi.domain.entities.dto.ExceptionDto;

import java.util.List;

public interface CryptocurrencyService {
    CryptocurrencyDto addCryptocurrency(CryptocurrencyDto cryptocurrencyDto) throws Exception;


    CryptocurrencyDto getCryptocurrency(String id) throws Exception;

    List<CryptocurrencyDto> getAllCryptocurrencies() throws Exception;

    CryptocurrencyDto updateCryptocurrency(String id, CryptocurrencyDto cryptocurrencyDto) throws Exception;

    String deleteCryptocurrency(String id) throws Exception;
}
