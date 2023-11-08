package com.tognati.hexagonal.config;

import com.tognati.hexagonal.adapter.out.FindAddressByZipCodeAdapter;
import com.tognati.hexagonal.adapter.out.FindCustomerByIDAdapter;
import com.tognati.hexagonal.adapter.out.InsertCustomerAdapter;
import com.tognati.hexagonal.application.core.usecase.InsertCustomerUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class InsertCustomerConfig {
    
    @Bean
    public InsertCustomerUseCase insertCustomerUseCase(
            FindAddressByZipCodeAdapter findAddressByZipCodeAdapter,
            InsertCustomerAdapter insertCustomerAdapter
    ) {
        return new InsertCustomerUseCase(insertCustomerAdapter, findAddressByZipCodeAdapter);
    }
    
}
