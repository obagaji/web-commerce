package com.customer.custException;

import com.customer.cutomer.Address;
import com.customer.cutomer.Cart;
import com.customer.cutomer.Customer;
import com.customer.cutomer.Item;

import java.util.List;
import java.util.function.Supplier;

public class NoSuchCustomerException extends RuntimeException implements Supplier<Customer> {
    @Override
    public Customer get() {
        return Customer.builder()
                .cart(new Cart(List.of(),0,0.0))
                .address(new Address("","","",""))
                .custPhone("")
                .custName("")
                .build();
    }
}
