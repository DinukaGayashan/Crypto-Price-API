package com.dinukagayashan.cryptopriceapi.external.service.impl;

import com.dinukagayashan.cryptopriceapi.domain.boundary.GetCryptocurrencyPrice;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import org.springframework.http.*;

@Configuration
@EnableScheduling
@Service
public class GetCryptocurrencyPriceImpl implements GetCryptocurrencyPrice {

    final String dataSourceUrl="https://rest.coinapi.io/v1/ohlcv/";

    RestTemplate restTemplate = new RestTemplate();

    @Scheduled(fixedRate = 100000)
    void getCryptocurrencyPriceData(){
        HttpHeaders headers=new HttpHeaders();
        headers.add("X-CoinAPI-Key","D6B76D7C-D516-4E9E-AFA0-3462D6552BD7");
        HttpEntity<String> entity = new HttpEntity<>(null, headers);
        ResponseEntity<String> response = restTemplate.exchange(dataSourceUrl + "BITSTAMP_SPOT_BTC_USD/latest?period_id=1DAY" , HttpMethod.GET, entity, String.class);

        System.out.println(response);
    }

}
