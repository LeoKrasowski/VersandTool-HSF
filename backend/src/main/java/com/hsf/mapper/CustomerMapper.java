package com.hsf.mapper;

import com.hsf.dto.CustomerRequestDTO;
import com.hsf.dto.CustomerResponseDTO;
import com.hsf.entity.Customer;

import org.mapstruct.Mapper;

@Mapper(componentModel="spring")
public interface CustomerMapper {
    
    default CustomerResponseDTO toCustomerResponseDTO(Customer customer){
        CustomerResponseDTO dto = new CustomerResponseDTO();
        dto.setId(customer.getId());
        dto.setNumber(customer.getNumber());
        dto.setName(customer.getName());
        dto.setLanguage(customer.getLanguage());
        dto.setNotificationNumber(customer.getNotificationNumber());
        dto.setInvoiceName(customer.getInvoiceName());
        dto.setWeekDays(customer.getWeekDays());
        return dto;
    }

    default Customer toCustomerEntity(CustomerRequestDTO dto){

        Customer customer = new Customer();
        customer.setNumber(dto.getNumber());
        customer.setName(dto.getName());
        customer.setLanguage(dto.getLanguage());
        customer.setNotificationNumber(dto.getNotificationNumber());
        customer.setInvoiceName(dto.getInvoiceName());
        customer.setWeekDays(dto.getWeekDays());
        return customer;
    }

}
