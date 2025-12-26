package com.items.ecommerce.modelItem;

import jakarta.annotation.Nonnull;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Setter
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long itemId;
    private String itemName;
    @Nonnull
    @Embedded
    private Address storeAddress;
    private double purchaseCost;
    @Nonnull
    private double price;
    @Nonnull
    private int quantity;
    private String currentLocation;
    private String itemDescription;
    private String imageAddress;

}
