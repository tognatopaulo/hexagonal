package com.tognati.hexagonal.adapter.out;

import com.tognati.hexagonal.adapter.out.repository.CustomerRepository;
import com.tognati.hexagonal.adapter.out.repository.mapper.CustomerEntityMapper;
import com.tognati.hexagonal.application.core.domain.Customer;
import com.tognati.hexagonal.application.ports.out.InsertCostumerOutputPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class InsertCustomerAdapter implements InsertCostumerOutputPort {
    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private CustomerEntityMapper customerEntityMapper;

    @Override
    public void insert(Customer customer) {
        var customerEntity = customerEntityMapper.toCustomerEntity(customer);
        customerRepository.save(customerEntity);
    }
}
