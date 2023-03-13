package com.dinukagayashan.cryptopriceapi.domain.service.impl;

import com.dinukagayashan.cryptopriceapi.domain.entities.Cryptocurrency;
import com.dinukagayashan.cryptopriceapi.domain.entities.dto.CryptocurrencyDto;
import com.dinukagayashan.cryptopriceapi.domain.service.CryptocurrencyService;
import com.dinukagayashan.cryptopriceapi.external.repository.CryptocurrencyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CryptocurrencyServiceImpl implements CryptocurrencyService {

    @Autowired
    private CryptocurrencyRepository cryptocurrencyRepository;

    private Cryptocurrency getCryptocurrency(CryptocurrencyDto cryptocurrencyDto) throws Exception{
        try {
            Cryptocurrency cryptocurrency=new Cryptocurrency();
            cryptocurrency.setId(cryptocurrencyDto.getId());
            cryptocurrency.setName(cryptocurrencyDto.getName());

            return cryptocurrency;
        }catch (Exception ex){
            throw ex;
        }
    }

    @Override
    public Cryptocurrency addCryptocurrency(CryptocurrencyDto cryptocurrencyDto) throws Exception {
        return cryptocurrencyRepository.save(getCryptocurrency(cryptocurrencyDto));
    }

    @Override
    public List<CryptocurrencyDto> getAllCryptocurrencies() {
        List<CryptocurrencyDto> cryptocurrencyDtoList=new ArrayList<CryptocurrencyDto>();
        List<Cryptocurrency> cryptocurrencyList=cryptocurrencyRepository.findAll();

        for(Cryptocurrency cryptocurrency: cryptocurrencyList){
            cryptocurrencyDtoList.add(new CryptocurrencyDto(cryptocurrency.getId(),cryptocurrency.getName()));
        }

        return cryptocurrencyDtoList;
    }
}
