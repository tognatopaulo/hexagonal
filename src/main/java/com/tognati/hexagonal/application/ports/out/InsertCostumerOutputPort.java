package com.tognati.hexagonal.application.ports.out;

import com.tognati.hexagonal.application.core.domain.Customer;

public interface InsertCostumerOutputPort {
    void insert(Customer customer);
}
