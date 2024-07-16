package com.example.th_customer_manager.reponsitories.impl;

import com.example.th_customer_manager.models.Customer;
import com.example.th_customer_manager.reponsitories.ICustomerReponsitory;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class CustomerReponsitory implements ICustomerReponsitory {
    private static List<Customer> customers = new ArrayList<>();

    static {
        customers.add(new Customer(1L, "Tinh", "tinh@gmail.com", "Ha noi"));
        customers.add(new Customer(2L, "Truong", "Truong@gmail.com", "Quang nam"));
        customers.add(new Customer(3L, "Ngoc", "Ngoc@gmail.com", "Hcm"));
        customers.add(new Customer(4L, "Long", "Long@gmail.com", "Hue"));
    }


    @Override
    public List<Customer> finfAll() {
        return customers;
    }

    @Override
    public  Customer findById(long id) {

        for (Customer customer : customers) {
            if (customer.getId() == id) {
                return customer;
            }
        }
        return null;
    }

    @Override
    public void save(Customer customer) {
        for (Customer customer1 : customers) {
            if (customer1.getId() == customer.getId()) {
                customer1.setName(customer.getName());
                customer1.setEmail(customer.getEmail());
                customer1.setAddress(customer.getAddress());
            }
        }
    }
}
