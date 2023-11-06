package com.tognati.hexagonal.application.ports.out;

import com.tognati.hexagonal.application.core.domain.Customer;

import java.util.Optional;

public interface FindCustomerByIDOutputPort {
    Optional<Customer> find(String id);
}
