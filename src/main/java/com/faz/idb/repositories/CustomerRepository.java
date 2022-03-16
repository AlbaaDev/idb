package com.faz.idb.repositories;

import com.faz.idb.models.Customer;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CustomerRepository extends AbstractUserRepository<Customer> {
    Optional<Customer> findByEmail(String email);
}
