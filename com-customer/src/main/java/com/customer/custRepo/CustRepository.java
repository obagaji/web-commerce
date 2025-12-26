package com.customer.custRepo;

import com.customer.cutomer.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


public interface CustRepository extends JpaRepository<Customer,String> {

    @Query("select c from Customer c where c.custPhone=:custPhone")
    Customer getAllCart(@Param("custPhone") String custPhone);

}
