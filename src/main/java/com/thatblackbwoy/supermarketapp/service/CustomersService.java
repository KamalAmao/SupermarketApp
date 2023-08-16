package com.thatblackbwoy.supermarketapp.service;

import com.thatblackbwoy.supermarketapp.dto.CustomersDto;
import com.thatblackbwoy.supermarketapp.dto.ProductsDto;
import com.thatblackbwoy.supermarketapp.dto.response.ApiResponse;

public interface CustomersService {
    ApiResponse addCustomer(CustomersDto customersDto);
    ApiResponse updateCustomer(Long customerId, CustomersDto customersDto);
    ApiResponse getById(Long customerId);
    ApiResponse getAllCustomers();
    ApiResponse deleteById(Long customerId);
    ApiResponse searchCustomerByName(String name);
}
