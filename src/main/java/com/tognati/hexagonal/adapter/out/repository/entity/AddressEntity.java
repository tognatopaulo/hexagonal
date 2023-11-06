package com.tognati.hexagonal.adapter.out.repository.entity;

import com.tognati.hexagonal.application.core.domain.Address;
import lombok.Data;

@Data
public class AddressEntity {
    private String street;
    private String city;
    private String state;
}
