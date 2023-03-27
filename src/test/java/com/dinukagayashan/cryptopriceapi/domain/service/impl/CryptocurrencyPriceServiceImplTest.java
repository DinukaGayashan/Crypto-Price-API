package com.dinukagayashan.cryptopriceapi.domain.service.impl;

import com.dinukagayashan.cryptopriceapi.external.repository.CryptocurrencyPriceRepository;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(MockitoJUnitRunner.class)
class CryptocurrencyPriceServiceImplTest {

    @Mock
    private CryptocurrencyPriceRepository cryptocurrencyPriceRepository;

    @InjectMocks
    private CryptocurrencyPriceServiceImpl cryptocurrencyPriceService;


    @Test
    void addCryptocurrencyPrice_success(){

    }

}