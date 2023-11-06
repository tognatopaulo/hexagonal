package com.tognati.hexagonal.adapter.out;

import com.tognati.hexagonal.adapter.out.repository.CustomerRepository;
import com.tognati.hexagonal.adapter.out.repository.mapper.CustomerEntityMapper;
import com.tognati.hexagonal.application.core.domain.Customer;
import com.tognati.hexagonal.application.ports.out.FindCustomerByIDOutputPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class FindCustomerByIDAdapter implements FindCustomerByIDOutputPort {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private CustomerEntityMapper customerEntityMapper;

    @Override
    public Optional<Customer> find(String id) {
        var customerEntity = customerRepository.findById(id);
        return customerEntity.map(entity -> customerEntityMapper.toCustomer(entity));
    }
}
