package com.customer.cutomer;


import jakarta.annotation.Nonnull;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Setter
@Getter
@Builder
public class Customer {
    @Id
    private String custPhone;
    @Nonnull
    private String custName;
    @Embedded
    private Address address;
    @Embedded
    private Cart cart;


}
