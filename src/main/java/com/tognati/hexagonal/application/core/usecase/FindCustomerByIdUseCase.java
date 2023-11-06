package com.tognati.hexagonal.application.core.usecase;

import com.tognati.hexagonal.application.core.domain.Customer;
import com.tognati.hexagonal.application.ports.in.FindCustomerByIDInputPort;
import com.tognati.hexagonal.application.ports.out.FindCustomerByIDOutputPort;

public class FindCustomerByIdUseCase implements FindCustomerByIDInputPort {

    private final FindCustomerByIDOutputPort findCustomerByIDOutputPort;

    FindCustomerByIdUseCase(FindCustomerByIDOutputPort findCustomerByIDOutputPort) {
        this.findCustomerByIDOutputPort = findCustomerByIDOutputPort;
    }

    @Override
    public Customer find(String id){
        return findCustomerByIDOutputPort.find(id)
                .orElseThrow(() -> new RuntimeException("Customer not found!"));
    }
}
