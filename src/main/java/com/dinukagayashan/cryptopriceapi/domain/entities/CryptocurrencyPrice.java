package com.dinukagayashan.cryptopriceapi.domain.entities;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "cryptocurrency_price")
@IdClass(CryptocurrencyPriceId.class)
public class CryptocurrencyPrice {

    @Id @Column(length = 10)
    private String currencyId;

    @Id
    private Date date;

    private Double openPrice;
    private Double highestPrice;
    private Double lowestPrice;
    private Double closePrice;

}


