package com.dinukagayashan.cryptopriceapi.domain.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Data
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
    private Double volume;

}


