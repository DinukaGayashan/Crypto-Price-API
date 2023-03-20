package com.dinukagayashan.cryptopriceapi.external.service.impl;

import com.dinukagayashan.cryptopriceapi.domain.boundary.GetCryptocurrencyPrice;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class GetCryptocurrencyPriceImpl implements GetCryptocurrencyPrice {

    final String dataSourceUrl="https://rest.coinapi.io/v1/exchangerate";

    RestTemplate restTemplate = new RestTemplate();



}
