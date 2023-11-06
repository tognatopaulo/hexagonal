package com.tognati.hexagonal.application.core.usecase;

import com.tognati.hexagonal.application.core.domain.Customer;
import com.tognati.hexagonal.application.ports.out.FindCustomerByIDOutputPort;

public class FindCustomerByIdUseCase {

    private final FindCustomerByIDOutputPort findCustomerByIDOutputPort;

    FindCustomerByIdUseCase(FindCustomerByIDOutputPort findCustomerByIDOutputPort) {
        this.findCustomerByIDOutputPort = findCustomerByIDOutputPort;
    }

    Customer find(String id){
        return findCustomerByIDOutputPort.find(id)
                .orElseThrow(() -> new RuntimeException("Customer not found!"));
    }
}
