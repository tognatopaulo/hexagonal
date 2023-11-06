package com.tognati.hexagonal.adapter.in.controller.mapper;

import com.tognati.hexagonal.adapter.in.controller.request.CustomerRequest;
import com.tognati.hexagonal.adapter.in.controller.response.CustomerResponse;
import com.tognati.hexagonal.application.core.domain.Customer;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.stereotype.Component;

@Component
@Mapper(componentModel = "spring")
public interface CustomerMapper {
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "address", ignore = true)
    @Mapping(target = "isValidCpf", ignore = true)
    Customer toCustomer(CustomerRequest customerRequest);

    CustomerResponse toCustomerResponse(Customer customer);
}
