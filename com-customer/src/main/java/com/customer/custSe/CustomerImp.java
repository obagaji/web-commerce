package com.customer.custSe;

import com.customer.custRepo.CustRepository;
import com.customer.custException.NoSuchCustomerException;
import com.customer.cutomer.Cart;
import com.customer.cutomer.Customer;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class CustomerImp implements CustomerService {

    private final Logger LOG = LoggerFactory.getLogger(CustomerImp.class);


    private final CustRepository custRepository;


    public List<Long> getCustomerSelected(String custId) {
        Cart cart= custRepository.getAllCart(custId).getCart();
        return cart.itemsId();
    }
    public List<Customer> getAllCustomers() {
        return custRepository.findAll();
    }

    public Customer getCustomerById(String phoneNumber) {
        return custRepository.findById(phoneNumber).orElseThrow(NoSuchCustomerException::new);
    }

    public int updateCustomer(String custId, Customer cust) {
        Optional<Customer> update = custRepository.findById(custId);
        LOG.info(update.get().toString());
        if (update.isPresent())
        {
            Customer saveCust=update.get();
            saveCust.setAddress(cust.getAddress());
            saveCust.setCart(cust.getCart());
            saveCust.setCustName(cust.getCustName());
            custRepository.save(saveCust);
            return 1;
        }

        return 0;
    }

    public void removeCustomer(String custId) {
        custRepository.deleteById(custId);
    }

    public Customer addCustomer(Customer cust) {
        return custRepository.save(cust);
    }
}
