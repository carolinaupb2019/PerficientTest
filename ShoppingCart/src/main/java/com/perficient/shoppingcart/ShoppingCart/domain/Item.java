package com.perficient.shoppingcart.ShoppingCart.domain;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.math.BigDecimal;

@Entity
@Table(schema = "item")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Item implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private int quantity;

    private BigDecimal unitPrice;

    private String productName;

    private String status;

}
