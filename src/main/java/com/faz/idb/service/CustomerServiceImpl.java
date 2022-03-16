package com.faz.idb.service;

import com.faz.idb.models.Customer;
import com.faz.idb.repositories.CustomerRepository;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
@Primary
public class CustomerServiceImpl extends AbstractUserServiceImpl<Customer> implements ICustomerService {

    public CustomerServiceImpl(CustomerRepository customerRepository) {
        super(customerRepository);
    }
}
