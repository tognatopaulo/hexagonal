package com.tognati.hexagonal.config;

import com.tognati.hexagonal.adapter.out.FindAddressByZipCodeAdapter;
import com.tognati.hexagonal.adapter.out.InsertCustomerAdapter;
import com.tognati.hexagonal.adapter.out.SendCpfValidationAdapter;
import com.tognati.hexagonal.application.core.usecase.InsertCustomerUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class InsertCustomerConfig {
    
    @Bean
    public InsertCustomerUseCase insertCustomerUseCase(
            FindAddressByZipCodeAdapter findAddressByZipCodeAdapter,
            InsertCustomerAdapter insertCustomerAdapter,
            SendCpfValidationAdapter sendCpfValidationAdapter
    ) {
        return new InsertCustomerUseCase(insertCustomerAdapter, findAddressByZipCodeAdapter, sendCpfValidationAdapter);
    }
    
}
