package com.dinukagayashan.cryptopriceapi.external.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;

@Configuration
public class ApiConfiguration {

    @Value("${CoinAPI.headerName}")
    private String headerName;

    @Value("${CoinAPI.headerValue}")
    private String headerValue;

    public HttpEntity<String> getHttpEntityConfiguration(){
        HttpHeaders headers = new HttpHeaders();
        headers.add(headerName, headerValue);
        return new HttpEntity<>(null, headers);
    }

}
