package com.tognati.hexagonal.adapter.in.consumer.mapper;

import com.tognati.hexagonal.adapter.in.consumer.message.CustomerMessage;
import com.tognati.hexagonal.application.core.domain.Customer;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.stereotype.Component;

@Component
@Mapper(componentModel = "spring")
public interface CustomerMessageMapper {

    @Mapping(target = "address", ignore = true)
    Customer toCustomer(CustomerMessage customerMessage);
    
}
