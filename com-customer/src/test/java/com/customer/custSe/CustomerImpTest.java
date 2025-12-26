package com.customer.custSe;

import com.customer.custRepo.CustRepository;
import com.customer.cutomer.Address;
import com.customer.cutomer.Cart;
import com.customer.cutomer.Customer;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CustomerImpTest {
    @Autowired
    CustRepository customerImp;
    @Test
    void addCustomer() {
        List<Long> listItem = new ArrayList<>();
        listItem.add(1L);
        listItem.add(2L);
        listItem.add(3L);
        listItem.add(4L);
        Customer customer = Customer.builder()
                .custName("Musa Daniel")
                .cart(new Cart(listItem,20,2100.0))
                .address(new Address("Nigeria","Lagos","Ojo","Olaoye"))
                .custPhone("283645474564")
                .build();
        Customer newC =customerImp.save(customer);
        assertSame(newC,customer);
    }
}