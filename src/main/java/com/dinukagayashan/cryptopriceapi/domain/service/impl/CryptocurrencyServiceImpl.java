package com.dinukagayashan.cryptopriceapi.domain.service.impl;

import com.dinukagayashan.cryptopriceapi.domain.entities.Cryptocurrency;
import com.dinukagayashan.cryptopriceapi.domain.entities.dto.CryptocurrencyDto;
import com.dinukagayashan.cryptopriceapi.domain.entities.dto.ExceptionDto;
import com.dinukagayashan.cryptopriceapi.domain.service.CryptocurrencyService;
import com.dinukagayashan.cryptopriceapi.external.repository.CryptocurrencyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CryptocurrencyServiceImpl implements CryptocurrencyService {

    @Autowired
    private CryptocurrencyRepository cryptocurrencyRepository;

    @Override
    public CryptocurrencyDto addCryptocurrency(CryptocurrencyDto cryptocurrencyDto) throws Exception {
        Cryptocurrency cryptocurrency = createCryptocurrency(cryptocurrencyDto);
        try {
            cryptocurrencyRepository.save(cryptocurrency);
            return cryptocurrencyDto;
        } catch (Exception ex) {
            throw new ExceptionDto(HttpStatus.INTERNAL_SERVER_ERROR, "Error Saving Cryptocurrency", cryptocurrencyDto);
        }
    }

    @Override
    public CryptocurrencyDto getCryptocurrency(String id) throws Exception {
        Cryptocurrency cryptocurrency = cryptocurrencyRepository.findById(id).orElseThrow(
                () -> new ExceptionDto(HttpStatus.NOT_FOUND, "No Such Cryptocurrency", id)
        );
        return createCryptocurrencyDto(cryptocurrency);
    }

    @Override
    public List<CryptocurrencyDto> getAllCryptocurrencies() throws Exception {
        List<CryptocurrencyDto> cryptocurrencyDtoList = new ArrayList<>();
        try {
            List<Cryptocurrency> cryptocurrencyList = cryptocurrencyRepository.findAll();
            for (Cryptocurrency cryptocurrency : cryptocurrencyList) {
                cryptocurrencyDtoList.add(createCryptocurrencyDto(cryptocurrency));
            }
        } catch (Exception ex) {
            throw new ExceptionDto(HttpStatus.NOT_FOUND, "No Cryptocurrency Exist", null);
        }
        return cryptocurrencyDtoList;
    }

    @Override
    public CryptocurrencyDto updateCryptocurrency(String id, CryptocurrencyDto newCryptocurrencyDto) throws Exception {
        try {
            CryptocurrencyDto oldCryptocurrencyDto = getCryptocurrency(id);
            CryptocurrencyDto cryptocurrencyDto = editCryptocurrencyDto(oldCryptocurrencyDto, newCryptocurrencyDto);
            addCryptocurrency(cryptocurrencyDto);
        } catch (Exception ex) {
            throw new ExceptionDto(HttpStatus.INTERNAL_SERVER_ERROR, "Error Updating Cryptocurrency", id);
        }
        return newCryptocurrencyDto;
    }

    @Override
    public String deleteCryptocurrency(String id) throws Exception {
        Cryptocurrency cryptocurrency = createCryptocurrency(getCryptocurrency(id));
        try {
            cryptocurrencyRepository.delete(cryptocurrency);
        } catch (Exception ex) {
            throw new ExceptionDto(HttpStatus.INTERNAL_SERVER_ERROR, "Error Deleting Cryptocurrency", id);
        }
        return id;
    }

    private Cryptocurrency createCryptocurrency(CryptocurrencyDto cryptocurrencyDto) throws Exception {
        try {
            Cryptocurrency cryptocurrency = new Cryptocurrency();
            cryptocurrency.setId(cryptocurrencyDto.getId());
            cryptocurrency.setName(cryptocurrencyDto.getName());
            return cryptocurrency;
        } catch (Exception ex) {
            throw new ExceptionDto(HttpStatus.INTERNAL_SERVER_ERROR, "Error Generating Cryptocurrency", cryptocurrencyDto);
        }
    }

    private CryptocurrencyDto createCryptocurrencyDto(Cryptocurrency cryptocurrency) throws Exception {
        try {
            CryptocurrencyDto cryptocurrencyDto = new CryptocurrencyDto();
            cryptocurrencyDto.setId(cryptocurrency.getId());
            cryptocurrencyDto.setName(cryptocurrency.getName());
            return cryptocurrencyDto;
        } catch (Exception ex) {
            throw new ExceptionDto(HttpStatus.INTERNAL_SERVER_ERROR, "Error Generating Cryptocurrency", cryptocurrency);
        }
    }

    private CryptocurrencyDto editCryptocurrencyDto(CryptocurrencyDto oldCryptocurrency, CryptocurrencyDto newCryptocurrency) throws Exception {
        try {
            oldCryptocurrency.setName(newCryptocurrency.getName());
            return oldCryptocurrency;
        } catch (Exception ex) {
            throw new ExceptionDto(HttpStatus.INTERNAL_SERVER_ERROR, "Error Editing Cryptocurrency", oldCryptocurrency);
        }
    }

}
