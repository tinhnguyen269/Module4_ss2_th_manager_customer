package com.example.th_customer_manager.reponsitories;

import com.example.th_customer_manager.models.Customer;

import java.util.List;

public interface ICustomerReponsitory {
    List<Customer> finfAll();

    Customer findById(long id);

    void save(Customer customer);

}
