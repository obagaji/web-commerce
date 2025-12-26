package com.customer.custSe;

import com.customer.cutomer.Customer;
import com.customer.cutomer.Item;

import java.util.List;

public interface CustomerService {
    List<Long> getCustomerSelected(String custId);
    List<Customer> getAllCustomers();
    Customer getCustomerById(String phoneNumber);
    int updateCustomer( String id,Customer cust);
    void removeCustomer(String custId);
    Customer addCustomer(Customer cust);

}
