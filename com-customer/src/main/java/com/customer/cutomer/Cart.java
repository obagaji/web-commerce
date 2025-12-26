package com.customer.cutomer;

import java.util.List;

public record Cart(List <Long> itemsId,String itemName, int quantity, double cost) {
}
