package com.tognati.hexagonal.config;

import com.tognati.hexagonal.adapter.out.DeleteCustomerByIdAdapter;
import com.tognati.hexagonal.application.core.usecase.DeleteCustomerByIdUseCase;
import com.tognati.hexagonal.application.core.usecase.FindCustomerByIdUseCase;
import com.tognati.hexagonal.application.ports.in.FindCustomerByIDInputPort;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DeleteCustomerByIdConfig {
    @Bean
    public DeleteCustomerByIdUseCase deleteCustomerByIdUseCase(
            FindCustomerByIdUseCase findCustomerByIdUseCase,
            DeleteCustomerByIdAdapter deleteCustomerByIdAdapter
       ) {
        return new DeleteCustomerByIdUseCase(findCustomerByIdUseCase, deleteCustomerByIdAdapter);
    }
}
