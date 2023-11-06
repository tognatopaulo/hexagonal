package com.tognati.hexagonal.adapter.out;

import com.tognati.hexagonal.adapter.in.controller.mapper.CustomerMapper;
import com.tognati.hexagonal.adapter.out.repository.CustomerRepository;
import com.tognati.hexagonal.adapter.out.repository.mapper.CustomerEntityMapper;
import com.tognati.hexagonal.application.core.domain.Customer;
import com.tognati.hexagonal.application.ports.out.UpdateCustomerOutputPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UpdateCustomerAdapter implements UpdateCustomerOutputPort {

    @Autowired
    public CustomerRepository customerRepository;

    @Autowired
    public CustomerEntityMapper customerEntityMapper;

    @Override
    public void update(Customer customer) {
        var customerEntity = customerEntityMapper.toCustomerEntity(customer);
        customerRepository.save(customerEntity);
    }
}
