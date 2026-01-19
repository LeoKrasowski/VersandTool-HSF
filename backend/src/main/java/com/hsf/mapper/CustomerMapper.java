package com.hsf.mapper;

import com.hsf.dto.CustomerRequestDTO;
import com.hsf.dto.CustomerResponseDTO;
import com.hsf.entity.Customer;
import org.mapstruct.Mapper;

@Mapper(componentModel="spring")
public interface CustomerMapper {

    CustomerResponseDTO toDto(Customer customer);

    Customer toEntity(CustomerRequestDTO dto);

}
