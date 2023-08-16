package com.thatblackbwoy.supermarketapp.service;

import com.thatblackbwoy.supermarketapp.dto.ProductsDto;
import com.thatblackbwoy.supermarketapp.dto.response.ApiResponse;

public interface ProductsService {
    ApiResponse addProduct(Long typeId, ProductsDto productsDto);
    ApiResponse updateProduct(Long productId, ProductsDto productsDto);
    ApiResponse getById(Long productId);
    ApiResponse getAllProducts();
    ApiResponse deleteById(Long productId);
    ApiResponse searchProductByName(String name);
}
