package com.tognati.hexagonal.application.core.usecase;

import com.tognati.hexagonal.application.ports.in.FindCustomerByIDInputPort;
import com.tognati.hexagonal.application.ports.out.DeleteCustomerByIdOutputPort;

public class DeleteCustomerByIdUseCase {
    
    private FindCustomerByIDInputPort findCustomerByIDInputPort;
    
    private final DeleteCustomerByIdOutputPort deleteCustomerByIdOutputPort;
    
    public  DeleteCustomerByIdUseCase(FindCustomerByIDInputPort findCustomerByIDInputPort,
                                      DeleteCustomerByIdOutputPort deleteCustomerByIdOutputPort) {
        this.findCustomerByIDInputPort = findCustomerByIDInputPort;
        this.deleteCustomerByIdOutputPort = deleteCustomerByIdOutputPort;
    }
    
    public void delete(String id) {
        findCustomerByIDInputPort.find(id);
        deleteCustomerByIdOutputPort.delete(id);
    }
}
