package com.example.th_customer_manager.services;

import com.example.th_customer_manager.models.Customer;

import java.util.List;

public interface ICustomerService {
    List<Customer> findAll();

   Customer findById(long id);

    void save(Customer customer);

}
