package com.tognati.hexagonal.adapter.out;

import com.tognati.hexagonal.adapter.out.repository.CustomerRepository;
import com.tognati.hexagonal.application.ports.out.DeleteCustomerByIdOutputPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DeleteCustomerByIdAdapter implements DeleteCustomerByIdOutputPort {

    @Autowired
    private CustomerRepository customerRepository;
    @Override
    public void delete(String id) {
        customerRepository.deleteById(id);
    }
}
