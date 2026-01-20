package com.hsf.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hsf.dto.CustomerRequestDTO;
import com.hsf.dto.CustomerResponseDTO;
import com.hsf.dto.UserResponseDTO;
import com.hsf.entity.Customer;
import com.hsf.entity.User;
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

    @GetMapping
        public List<CustomerResponseDTO> getAll() {
        
        List<Customer> customers = customerService.getAllCustomers(); //List of customers from database
        List<CustomerResponseDTO> customerResponseDTOs = new ArrayList<>(); //New lists of DTOs entities

        for(Customer customer : customers){ //go via user list from database
            CustomerResponseDTO customerResponseDTO = customerMapper.toDto(customer); //mapping from User to dto
            customerResponseDTOs.add(customerResponseDTO); //save in list DTOs
        }

        return customerResponseDTOs;
    }

    @PostMapping("/add")
        public CustomerResponseDTO addCustomer(@RequestBody CustomerRequestDTO customerRequestDTO){  //frontend layer

        Customer customer = customerService.createCustomer(customerMapper.toEntity(customerRequestDTO)); //service layer
        return customerMapper.toDto(customer); //return to frontend
    }
}
