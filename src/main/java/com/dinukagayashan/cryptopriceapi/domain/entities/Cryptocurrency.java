package com.dinukagayashan.cryptopriceapi.domain.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "cryptocurrencies")
public class Cryptocurrency {

    @Id
    @Column(length = 10)
    private String id;
    private String name;
}
