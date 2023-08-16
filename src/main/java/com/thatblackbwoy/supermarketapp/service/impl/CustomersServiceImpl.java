package com.thatblackbwoy.supermarketapp.service.impl;

import com.thatblackbwoy.supermarketapp.dto.CustomersDto;
import com.thatblackbwoy.supermarketapp.dto.ProductsDto;
import com.thatblackbwoy.supermarketapp.dto.response.ApiResponse;
import com.thatblackbwoy.supermarketapp.model.Customers;
import com.thatblackbwoy.supermarketapp.model.Products;
import com.thatblackbwoy.supermarketapp.repository.CustomersRepository;
import com.thatblackbwoy.supermarketapp.repository.ProductsRepository;
import com.thatblackbwoy.supermarketapp.service.CustomersService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class CustomersServiceImpl implements CustomersService {
    private final CustomersRepository customersRepository;
    @Override
    public ApiResponse addCustomer(CustomersDto customersDto) {
        Customers customer = Customers.builder()
                .firstname(customersDto.getFirstname())
                .lastname(customersDto.getLastname())
                .email(customersDto.getEmail())
                .build();
        Customers response = customersRepository.save(customer);
        log.info("Customer successfully added {}", response);

        return ApiResponse.builder()
                .success(true)
                .message("Customer successfully added")
                .data(response)
                .build();
    }
    @Override
    public ApiResponse updateCustomer(Long customerId, CustomersDto customersDto){
        Customers customer = customersRepository.findById(customerId).orElseThrow(()-> new RuntimeException());
        customer.setFirstname(customersDto.getFirstname());
        customer.setLastname(customersDto.getLastname());
        customer.setEmail(customersDto.getEmail());

        Customers response = customersRepository.save(customer);
        log.info("Customer with id " +customerId+ " successfully updated {}", response);

        return ApiResponse.builder()
                .success(true)
                .message("Customer with id " +customerId+ " successfully updated")
                .data(response)
                .build();
    }
    @Override
    public ApiResponse getById(Long customerId) {
        Customers customer = customersRepository.findById(customerId).orElseThrow(()-> new RuntimeException());
        log.info("Customer with id " +customerId+ " retrieved successfully {}", customer);

        return ApiResponse.builder()
                .success(true)
                .message("Customer with id " +customerId+ " retrieved successfully")
                .data(customer)
                .build();
    }

    @Override
    public ApiResponse getAllCustomers() {
        List<Customers> customers = customersRepository.findAll();
        log.info("All available customers successfully retrieved {}", customers);

        return ApiResponse.builder()
                .success(true)
                .message("All available products successfully retrieved")
                .data(customers)
                .build();
    }

    @Override
    public ApiResponse deleteById(Long customerId) {
        Customers customer = customersRepository.findById(customerId).orElseThrow(()-> new RuntimeException());
        customersRepository.deleteCustomersById(customerId);
        log.info("Customer with id " +customerId+ " has been deleted {}", customer);

        return ApiResponse.builder()
                .success(true)
                .message("Customer with id " +customerId+ " has been deleted")
                .build();
    }
    @Override
    public ApiResponse searchCustomerByName(String name) {
        List<Customers> customers = customersRepository.findByFirstnameContaining(name);
        log.info("All customers name containing " +name+ " successfully retrieved {}", customers);

        return ApiResponse.builder()
                .success(true)
                .message("All customers name containing " +name+ " successfully retrieved ")
                .data(customers)
                .build();
    }
}
