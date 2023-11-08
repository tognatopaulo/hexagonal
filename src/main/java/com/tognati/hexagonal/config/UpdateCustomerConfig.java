package com.tognati.hexagonal.config;

import com.tognati.hexagonal.adapter.out.FindAddressByZipCodeAdapter;
import com.tognati.hexagonal.adapter.out.UpdateCustomerAdapter;
import com.tognati.hexagonal.application.core.usecase.FindCustomerByIdUseCase;
import com.tognati.hexagonal.application.core.usecase.UpdateCustomerUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UpdateCustomerConfig {
    
    @Bean
    public UpdateCustomerUseCase updateCustomerUseCase(
            FindCustomerByIdUseCase findCustomerByIdUseCase,
            FindAddressByZipCodeAdapter findAddressByZipCodeAdapter,
            UpdateCustomerAdapter updateCustomerAdapter
    ) {
        return new UpdateCustomerUseCase(findCustomerByIdUseCase,findAddressByZipCodeAdapter, updateCustomerAdapter);
    }
}
