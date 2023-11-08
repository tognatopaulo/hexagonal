package com.tognati.hexagonal.adapter.in.controller;

import com.tognati.hexagonal.adapter.in.controller.mapper.CustomerMapper;
import com.tognati.hexagonal.adapter.in.controller.request.CustomerRequest;
import com.tognati.hexagonal.adapter.in.controller.response.CustomerResponse;
import com.tognati.hexagonal.application.core.domain.Customer;
import com.tognati.hexagonal.application.ports.in.DeleteCustomerInputPort;
import com.tognati.hexagonal.application.ports.in.FindCustomerByIDInputPort;
import com.tognati.hexagonal.application.ports.in.InsertCustomerInputPort;
import com.tognati.hexagonal.application.ports.in.UpdateCustomerInputPort;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/customers")
public class CustomerController {

    @Autowired
    private InsertCustomerInputPort insertCustomerInputPort;

    @Autowired
    private CustomerMapper customerMapper;

    @Autowired
    private FindCustomerByIDInputPort findCustomerByIDInputPort;

    @Autowired
    private UpdateCustomerInputPort updateCustomerInputPort;
    
    @Autowired
    private DeleteCustomerInputPort deleteCustomerInputPort;

    @PostMapping
    public ResponseEntity<Void> insert(@Valid @RequestBody CustomerRequest customerRequest){
        var customer = customerMapper.toCustomer(customerRequest);
        insertCustomerInputPort.insert(customer, customerRequest.getZipCode());
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<CustomerResponse> findById(@PathVariable final String id){
        var customer = findCustomerByIDInputPort.find(id);
        var customerResponse = customerMapper.toCustomerResponse(customer);
        return ResponseEntity.ok().body(customerResponse);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> update(@PathVariable final String id, @Valid @RequestBody CustomerRequest customerRequest){
        Customer customer = customerMapper.toCustomer(customerRequest);
        customer.setId(id);
        updateCustomerInputPort.update(customer, customerRequest.getZipCode());
        return ResponseEntity.noContent().build();
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable final String id) {
        deleteCustomerInputPort.delete(id);
        return ResponseEntity.noContent().build();
    }

}
