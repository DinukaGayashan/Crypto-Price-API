package com.dinukagayashan.cryptopriceapi.domain.service;

import com.dinukagayashan.cryptopriceapi.domain.entities.CryptocurrencyPriceId;
import com.dinukagayashan.cryptopriceapi.domain.entities.dto.CryptocurrencyPriceDto;
import com.dinukagayashan.cryptopriceapi.domain.entities.dto.ExceptionDto;

public interface CryptocurrencyPriceService {
    CryptocurrencyPriceDto addCryptocurrencyPrice(CryptocurrencyPriceDto cryptocurrencyPriceDto) throws ExceptionDto;

    CryptocurrencyPriceDto getCryptocurrencyPrice(CryptocurrencyPriceId id) throws ExceptionDto;
}
