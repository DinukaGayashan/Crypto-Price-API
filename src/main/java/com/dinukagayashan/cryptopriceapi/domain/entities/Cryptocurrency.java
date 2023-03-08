package com.dinukagayashan.cryptopriceapi.domain.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "cryptocurrencies")
public class Cryptocurrency {
    private String id;
    private String name;
}
