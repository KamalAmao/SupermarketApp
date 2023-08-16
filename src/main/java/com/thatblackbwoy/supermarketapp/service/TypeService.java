package com.thatblackbwoy.supermarketapp.service;

import com.thatblackbwoy.supermarketapp.dto.TypeDto;
import com.thatblackbwoy.supermarketapp.dto.response.ApiResponse;

public interface TypeService {
    ApiResponse createType(TypeDto typeDto);
    ApiResponse updateType(Long typeId, TypeDto typeDto);
    ApiResponse getAllType();
    ApiResponse searchTypeByName(String name);
}
