package com.dinukagayashan.cryptopriceapi.domain.entities;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "cryptocurrencies")
public class Cryptocurrency {

    @Id @Column(length = 10)
    private String id;
    private String name;
}
