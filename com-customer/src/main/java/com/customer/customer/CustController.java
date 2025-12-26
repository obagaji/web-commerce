package com.customer.customer;

import com.customer.custSe.CustomerImp;
import com.customer.cutomer.Customer;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

@RestController
@RequestMapping("/api/customer")
@RequiredArgsConstructor
public class CustController {

    private final Logger LOG = LoggerFactory.getLogger(CustController.class);
    private final CustomerImp customerImp;

    @GetMapping("/all")
    public ResponseEntity<List<Customer>>getAllCustomer() throws ExecutionException, InterruptedException {
        CompletableFuture<List<Customer>> getAll = CompletableFuture.completedFuture(
               customerImp.getAllCustomers()
        );
        LOG.info(Thread.currentThread().getName());
        return ResponseEntity.ok( getAll.get());
    }
    @GetMapping("/{id}")
    public ResponseEntity<Customer>getCustomerId(@PathVariable("id") String id) throws ExecutionException, InterruptedException {
        CompletableFuture<Customer> getAll = CompletableFuture.completedFuture(
                customerImp.getCustomerById(id)
        );
        LOG.info(Thread.currentThread().getName());
        return ResponseEntity.ok( getAll.get());
    }
    @DeleteMapping("/remove/{custId}")
    public ResponseEntity<String>removeCustomer(@PathVariable("custId") String custId)
    {
        customerImp.removeCustomer(custId);
        return ResponseEntity.ok(customerImp.getCustomerById(custId).toString());
    }
    @PutMapping("/update/{custId}")
    public ResponseEntity<Integer>updateCustomer(@PathVariable("custId")String custId,@RequestBody Customer cust)
    {
        int x = customerImp.updateCustomer(custId,cust);
        return ResponseEntity.ok(x);
    }
    @PostMapping("/add")
    public ResponseEntity<Customer>addCustomer(@RequestBody Customer customer)
    {
        Customer cust = customerImp.addCustomer(customer);
        return ResponseEntity.ok(cust);
    }
}
