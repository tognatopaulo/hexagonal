package com.tognati.hexagonal.application.core.usecase;

import com.tognati.hexagonal.application.core.domain.Customer;
import com.tognati.hexagonal.application.ports.in.InsertCustomerInputPort;
import com.tognati.hexagonal.application.ports.out.FindAddressByZipCodeOutputPort;
import com.tognati.hexagonal.application.ports.out.InsertCostumerOutputPort;

public class InsertCustomerUseCase implements InsertCustomerInputPort {
    private final FindAddressByZipCodeOutputPort findAddressByZipCodeOutputPort;
    private final InsertCostumerOutputPort insertCostumerOutputPort;

    public InsertCustomerUseCase(
            InsertCostumerOutputPort insertCostumerOutputPort,
            FindAddressByZipCodeOutputPort findAddressByZipCodeOutputPort) {
        this.findAddressByZipCodeOutputPort = findAddressByZipCodeOutputPort;
        this.insertCostumerOutputPort = insertCostumerOutputPort;
    }

    @Override
    public void insert(Customer customer, String zipCode){
        var address = findAddressByZipCodeOutputPort.find(zipCode);
        customer.setAddress(address);
        insertCostumerOutputPort.insert(customer);
    }
}
