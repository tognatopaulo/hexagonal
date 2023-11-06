package com.tognati.hexagonal.adapter.out.repository.mapper;

import com.tognati.hexagonal.adapter.out.repository.entity.CustomerEntity;
import com.tognati.hexagonal.application.core.domain.Customer;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Mapper(componentModel = "spring")
@Component()
public interface CustomerEntityMapper {
    CustomerEntity toCustomerEntity(Customer customer);
}
