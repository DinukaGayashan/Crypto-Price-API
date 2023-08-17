package com.dinukagayashan.cryptopriceapi.external.service.impl;

import com.dinukagayashan.cryptopriceapi.domain.boundary.GetCryptocurrencyPrice;
import com.dinukagayashan.cryptopriceapi.external.configuration.ApiConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@EnableScheduling
@Service
public class GetCryptocurrencyPriceImpl implements GetCryptocurrencyPrice {

    @Value("${CoinAPI.dataSourceAddress}")
    private String dataSourceUrl;

    @Autowired
    ApiConfiguration apiConfiguration;

    @Scheduled(fixedRate = 100000)
    public void getCryptocurrencyPriceData() {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> response = restTemplate.exchange(dataSourceUrl, HttpMethod.GET, apiConfiguration.getHttpEntityConfiguration(), String.class);

        System.out.println(response);
    }

}
