package com.tognati.hexagonal.application.ports.out;

import com.tognati.hexagonal.application.core.domain.Customer;

public interface UpdateCustomerOutputPort {
    void update(Customer customer);
}
