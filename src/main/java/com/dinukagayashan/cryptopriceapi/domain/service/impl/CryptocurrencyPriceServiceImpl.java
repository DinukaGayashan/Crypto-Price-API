package com.dinukagayashan.cryptopriceapi.domain.service.impl;

import com.dinukagayashan.cryptopriceapi.domain.entities.CryptocurrencyPrice;
import com.dinukagayashan.cryptopriceapi.domain.entities.CryptocurrencyPriceId;
import com.dinukagayashan.cryptopriceapi.domain.entities.dto.CryptocurrencyPriceDto;
import com.dinukagayashan.cryptopriceapi.domain.entities.dto.ExceptionDto;
import com.dinukagayashan.cryptopriceapi.domain.service.CryptocurrencyPriceService;
import com.dinukagayashan.cryptopriceapi.external.repository.CryptocurrencyPriceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class CryptocurrencyPriceServiceImpl implements CryptocurrencyPriceService {

    @Autowired
    private CryptocurrencyPriceRepository cryptocurrencyPriceRepository;

    @Override
    public CryptocurrencyPriceDto addCryptocurrencyPrice(CryptocurrencyPriceDto cryptocurrencyPriceDto) throws ExceptionDto{
        CryptocurrencyPrice cryptocurrencyPrice=createCryptocurrencyPrice(cryptocurrencyPriceDto);
        try {
            cryptocurrencyPriceRepository.save(cryptocurrencyPrice);
            return cryptocurrencyPriceDto;
        } catch (Exception ex) {
            throw new ExceptionDto(HttpStatus.INTERNAL_SERVER_ERROR, "Error Saving Cryptocurrency Price", cryptocurrencyPriceDto);
        }
    }

    @Override
    public CryptocurrencyPriceDto getCryptocurrencyPrice(CryptocurrencyPriceId id) throws ExceptionDto {
        CryptocurrencyPrice cryptocurrencyPrice = cryptocurrencyPriceRepository.findById(id).orElseThrow(
                () -> new ExceptionDto(HttpStatus.NOT_FOUND, "No Such Cryptocurrency Price ID", id)
        );
        return createCryptocurrencyPriceDto(cryptocurrencyPrice);
    }

    private CryptocurrencyPrice createCryptocurrencyPrice(CryptocurrencyPriceDto cryptocurrencyPriceDto){
        CryptocurrencyPrice cryptocurrencyPrice=new CryptocurrencyPrice();
        cryptocurrencyPrice.setCurrencyId(cryptocurrencyPriceDto.getCurrencyId());
        cryptocurrencyPrice.setDate(cryptocurrencyPriceDto.getDate());
        cryptocurrencyPrice.setOpenPrice(cryptocurrencyPriceDto.getOpenPrice());
        cryptocurrencyPrice.setHighestPrice(cryptocurrencyPriceDto.getHighestPrice());
        cryptocurrencyPrice.setLowestPrice(cryptocurrencyPriceDto.getLowestPrice());
        cryptocurrencyPrice.setClosePrice(cryptocurrencyPriceDto.getClosePrice());

        return cryptocurrencyPrice;
    }

    private CryptocurrencyPriceDto createCryptocurrencyPriceDto(CryptocurrencyPrice cryptocurrencyPrice){
        CryptocurrencyPriceDto cryptocurrencyPriceDto=new CryptocurrencyPriceDto();
        cryptocurrencyPriceDto.setCurrencyId(cryptocurrencyPrice.getCurrencyId());
        cryptocurrencyPriceDto.setDate(cryptocurrencyPrice.getDate());
        cryptocurrencyPriceDto.setOpenPrice(cryptocurrencyPrice.getOpenPrice());
        cryptocurrencyPriceDto.setHighestPrice(cryptocurrencyPrice.getHighestPrice());
        cryptocurrencyPriceDto.setLowestPrice(cryptocurrencyPrice.getLowestPrice());
        cryptocurrencyPriceDto.setClosePrice(cryptocurrencyPrice.getClosePrice());
        cryptocurrencyPriceDto.setVolume(cryptocurrencyPrice.getVolume());

        return cryptocurrencyPriceDto;
    }

}
