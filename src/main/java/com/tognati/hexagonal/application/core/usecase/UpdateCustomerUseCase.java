package com.tognati.hexagonal.application.core.usecase;

import com.tognati.hexagonal.application.core.domain.Customer;
import com.tognati.hexagonal.application.ports.in.FindCustomerByIDInputPort;
import com.tognati.hexagonal.application.ports.in.UpdateCustomerInputPort;
import com.tognati.hexagonal.application.ports.out.FindAddressByZipCodeOutputPort;
import com.tognati.hexagonal.application.ports.out.UpdateCustomerOutputPort;

public class UpdateCustomerUseCase implements UpdateCustomerInputPort {

    private final FindCustomerByIDInputPort findCustomerByIDInputPort;
    private final FindAddressByZipCodeOutputPort findAddressByZipCodeOutputPort;

    private final UpdateCustomerOutputPort updateCustomerOutputPort;

    public UpdateCustomerUseCase(FindCustomerByIDInputPort findCustomerByIDInputPort,
                                 FindAddressByZipCodeOutputPort findAddressByZipCodeOutputPort,
                                 UpdateCustomerOutputPort updateCustomerOutputPort) {
        this.findCustomerByIDInputPort = findCustomerByIDInputPort;
        this.findAddressByZipCodeOutputPort = findAddressByZipCodeOutputPort;
        this.updateCustomerOutputPort = updateCustomerOutputPort;
    }

    @Override
    public void update(Customer customer, String zipCode) {
        findCustomerByIDInputPort.find(customer.getId());
        var address = findAddressByZipCodeOutputPort.find(zipCode);
        customer.setAddress(address);
        updateCustomerOutputPort.update(customer);
    }
}
