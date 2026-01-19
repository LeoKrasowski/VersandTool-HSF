package com.hsf.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hsf.dto.CustomerRequestDTO;
import com.hsf.dto.CustomerResponseDTO;
import com.hsf.entity.Customer;
import com.hsf.mapper.CustomerMapper;
import com.hsf.service.CustomerService;

@RestController
@RequestMapping("/api/customers")
public class CustomerController {

    private final CustomerService customerService;
    private final CustomerMapper customerMapper;

    public CustomerController(CustomerService customerService, CustomerMapper customerMapper) {
        this.customerService = customerService;
        this.customerMapper = customerMapper;
    }
    // Define REST endpoints here (e.g., GET, POST, PUT, DELETE)

    @PostMapping("/add")
        public CustomerResponseDTO addCustomer(@RequestBody CustomerRequestDTO customerRequestDTO){  //frontend layer

        Customer customer = customerService.createCustomer(customerMapper.toEntity(customerRequestDTO)); //service layer
        return customerMapper.toDto(customer); //return to frontend
    }
}
