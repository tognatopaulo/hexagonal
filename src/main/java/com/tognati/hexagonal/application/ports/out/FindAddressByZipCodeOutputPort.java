package com.tognati.hexagonal.application.ports.out;

import com.tognati.hexagonal.application.core.domain.Address;

public interface FindAddressByZipCodeOutputPort {
    Address find(String zipCode);
}
