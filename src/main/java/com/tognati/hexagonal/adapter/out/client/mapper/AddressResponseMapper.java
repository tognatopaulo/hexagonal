package com.tognati.hexagonal.adapter.out.client.mapper;

import com.tognati.hexagonal.adapter.out.client.response.AddressResponse;
import com.tognati.hexagonal.application.core.domain.Address;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Component
@Mapper(componentModel = "spring")
public interface AddressResponseMapper {
    Address toAddress(AddressResponse addressResponse);
}
