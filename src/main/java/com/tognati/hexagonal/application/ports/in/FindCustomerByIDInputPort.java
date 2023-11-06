package com.tognati.hexagonal.application.ports.in;

import com.tognati.hexagonal.application.core.domain.Customer;
import org.springframework.stereotype.Component;

@Component
public interface FindCustomerByIDInputPort {
    Customer find(String id);
}
