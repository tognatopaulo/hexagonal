package com.tognati.hexagonal.adapter.out;

import com.tognati.hexagonal.adapter.out.client.FindAddressByZipCodeClient;
import com.tognati.hexagonal.adapter.out.client.mapper.AddressResponseMapper;
import com.tognati.hexagonal.application.core.domain.Address;
import com.tognati.hexagonal.application.ports.out.FindAddressByZipCodeOutputPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class FindAddressByZipCodeAdapter implements FindAddressByZipCodeOutputPort {

    @Autowired
    private FindAddressByZipCodeClient findAddressByZipCodeClient;

    @Autowired
    private AddressResponseMapper addressResponseMapper;

    @Override
    public Address find(String zipCode) {
        var addressResponse = findAddressByZipCodeClient.find(zipCode);
        return addressResponseMapper.toAddress(addressResponse);
    }
}
