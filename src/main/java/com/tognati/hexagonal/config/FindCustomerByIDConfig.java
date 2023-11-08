package com.tognati.hexagonal.config;

import com.tognati.hexagonal.adapter.out.FindCustomerByIDAdapter;
import com.tognati.hexagonal.application.core.usecase.FindCustomerByIdUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FindCustomerByIDConfig {

    @Bean
    public FindCustomerByIdUseCase findCustomerByIdUseCase(
            FindCustomerByIDAdapter findCustomerByIDAdapter
    ) {
        return new FindCustomerByIdUseCase(findCustomerByIDAdapter);
    } 

}
