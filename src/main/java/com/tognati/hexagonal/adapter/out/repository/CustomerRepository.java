package com.tognati.hexagonal.adapter.out.repository;

import com.tognati.hexagonal.adapter.out.repository.entity.CustomerEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CustomerRepository extends MongoRepository<CustomerEntity, String> {
}
