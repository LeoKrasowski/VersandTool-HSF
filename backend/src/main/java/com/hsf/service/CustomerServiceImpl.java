package com.hsf.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hsf.entity.Customer;
import com.hsf.repository.CustomerRepository;
import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService{

    // Implementation of UserService methods would go here
    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    @Override
    public Customer getCustomerById(Long id) {
        return customerRepository.findById(id).orElse(null);
    }

    @Override
    public Customer createCustomer(Customer customer) {
        return customerRepository.save(customer);
    }
    @Override
    public Customer updateCustomer(Long id, Customer customer) {
        customer.setId(id);
        return customerRepository.save(customer);
    }

    @Override
    public void deleteCustomer(Long id, Customer customer) {
        customer.setId(id);
        customerRepository.delete(customer);
    }

}
