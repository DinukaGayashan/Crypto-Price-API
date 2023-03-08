package com.dinukagayashan.cryptopriceapi.domain.service.impl;

import com.dinukagayashan.cryptopriceapi.domain.entities.Cryptocurrency;
import com.dinukagayashan.cryptopriceapi.domain.entities.dto.CryptocurrencyDto;
import com.dinukagayashan.cryptopriceapi.domain.service.CryptocurrencyService;
import com.dinukagayashan.cryptopriceapi.external.repository.CryptocurrencyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CryptocurrencyServiceImpl implements CryptocurrencyService {

    @Autowired
    private CryptocurrencyRepository cryptocurrencyRepository;

    @Override
    public Cryptocurrency addCryptocurrency(CryptocurrencyDto cryptocurrencyDto) {
        Cryptocurrency cryptocurrency=new Cryptocurrency();
        cryptocurrency.setId(cryptocurrencyDto.getId());
        cryptocurrency.setName(cryptocurrencyDto.getName());

        return cryptocurrencyRepository.save(cryptocurrency);
    }
}
