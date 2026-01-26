package com.hsf.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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

    @GetMapping
        public List<CustomerResponseDTO> getAll() {
        
        List<Customer> customers = customerService.getAllCustomers(); //List of customers from database
        List<CustomerResponseDTO> customerResponseDTOs = new ArrayList<>(); //New lists of DTOs entities

        for(Customer customer : customers){ //go via user list from database
            CustomerResponseDTO customerResponseDTO = customerMapper.toCustomerResponseDTO(customer); //mapping from User to dto
            customerResponseDTOs.add(customerResponseDTO); //save in list DTOs
        }

        return customerResponseDTOs;
    }

    @PostMapping("/add")
        public CustomerResponseDTO addCustomer(@RequestBody CustomerRequestDTO customerRequestDTO){  //frontend layer

        Customer customer = customerService.createCustomer(customerMapper.toCustomerEntity(customerRequestDTO)); //service layer
        return customerMapper.toCustomerResponseDTO(customer); //return to frontend
    }

    @PutMapping("/{id}")
        public CustomerResponseDTO updateCustomer(@PathVariable Long id, @RequestBody CustomerRequestDTO customerRequestDTO){ //front
            Customer customer = customerService.updateCustomer(id, customerMapper.toCustomerEntity(customerRequestDTO)); //service made update func. in params id and mapping to entity
            return customerMapper.toCustomerResponseDTO(customer); // return value in json style
    }

    @PutMapping("/{id}/delete")
        public ResponseEntity<Void> deleteCustomer(@PathVariable Long id, @RequestBody CustomerRequestDTO customerRequestDTO){
            customerService.deleteCustomer(id, customerMapper.toCustomerEntity(customerRequestDTO));
            return ResponseEntity.ok().build();
        }

}
