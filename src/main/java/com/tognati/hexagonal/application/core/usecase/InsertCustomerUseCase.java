package com.tognati.hexagonal.application.core.usecase;

import com.tognati.hexagonal.application.core.domain.Customer;
import com.tognati.hexagonal.application.ports.in.InsertCustomerInputPort;
import com.tognati.hexagonal.application.ports.out.FindAddressByZipCodeOutputPort;
import com.tognati.hexagonal.application.ports.out.InsertCostumerOutputPort;
import com.tognati.hexagonal.application.ports.out.SendCpfForValidationOutputPort;

public class InsertCustomerUseCase implements InsertCustomerInputPort {
    private final FindAddressByZipCodeOutputPort findAddressByZipCodeOutputPort;
    private final InsertCostumerOutputPort insertCostumerOutputPort;
    
    private final SendCpfForValidationOutputPort sendCpfForValidationOutputPort;

    public InsertCustomerUseCase(
            InsertCostumerOutputPort insertCostumerOutputPort,
            FindAddressByZipCodeOutputPort findAddressByZipCodeOutputPort, 
            SendCpfForValidationOutputPort sendCpfForValidationOutputPort) {
        this.findAddressByZipCodeOutputPort = findAddressByZipCodeOutputPort;
        this.insertCostumerOutputPort = insertCostumerOutputPort;
        this.sendCpfForValidationOutputPort = sendCpfForValidationOutputPort;
    }

    @Override
    public void insert(Customer customer, String zipCode){
        var address = findAddressByZipCodeOutputPort.find(zipCode);
        customer.setAddress(address);
        insertCostumerOutputPort.insert(customer);
        sendCpfForValidationOutputPort.send(customer.getCpf());
    }
}
