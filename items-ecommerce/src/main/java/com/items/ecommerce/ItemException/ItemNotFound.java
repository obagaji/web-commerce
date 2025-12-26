package com.items.ecommerce.ItemException;

import com.items.ecommerce.modelItem.Address;
import com.items.ecommerce.modelItem.Item;

import java.util.function.Supplier;

public class ItemNotFound extends RuntimeException implements Supplier<Item> {
    @Override
    public Item get() {
        return Item.builder()
                .currentLocation("")
                .itemId(0L)
                .imageAddress("")
                .itemDescription("")
                .itemName("")
                .price(0.0)
                .purchaseCost(0.0)
                .quantity(0)
                .storeAddress(new Address("","","",""))
                .build();
    }
}
