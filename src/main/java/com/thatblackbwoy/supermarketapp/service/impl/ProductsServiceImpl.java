package com.thatblackbwoy.supermarketapp.service.impl;

import com.thatblackbwoy.supermarketapp.dto.ProductsDto;
import com.thatblackbwoy.supermarketapp.dto.response.ApiResponse;
import com.thatblackbwoy.supermarketapp.model.Products;
import com.thatblackbwoy.supermarketapp.model.Type;
import com.thatblackbwoy.supermarketapp.repository.ProductsRepository;
import com.thatblackbwoy.supermarketapp.repository.TypeRepository;
import com.thatblackbwoy.supermarketapp.service.ProductsService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProductsServiceImpl implements ProductsService {
    private final TypeRepository typeRepository;
    private final ProductsRepository productsRepository;
    @Override
    public ApiResponse addProduct(Long typeId, ProductsDto productsDto) {
        Type type = typeRepository.findById(typeId).orElseThrow(()-> new RuntimeException());
        Products products = Products.builder()
                .name(productsDto.getName())
                .description(productsDto.getDescription())
                .price(productsDto.getPrice())
                .type(type)
                .build();
        Products response = productsRepository.save(products);
        log.info("Products successfully added {}", response);

        return ApiResponse.builder()
                .success(true)
                .message("Products successfully added")
                .data(response)
                .build();
    }
    @Override
    public ApiResponse updateProduct(Long productId, ProductsDto productsDto){
        Products products = productsRepository.findById(productId).orElseThrow(()-> new RuntimeException());
        products.setName(productsDto.getName());
        products.setDescription(productsDto.getDescription());
        products.setPrice(productsDto.getPrice());

        Products response = productsRepository.save(products);
        log.info("Product with id " +productId+ " successfully updated {}", response);

        return ApiResponse.builder()
                .success(true)
                .message("Product with id " +productId+ " successfully updated")
                .data(response)
                .build();
    }
    @Override
    public ApiResponse getById(Long productId) {
        Products product = productsRepository.findById(productId).orElseThrow(()-> new RuntimeException());
        log.info("Product with id " +productId+ " retrieved successfully {}", product);

        return ApiResponse.builder()
                .success(true)
                .message("Product with id " +productId+ " retrieved successfully")
                .data(product)
                .build();
    }

    @Override
    public ApiResponse getAllProducts() {
        List<Products> products = productsRepository.findAll();
        log.info("All available products successfully retrieved {}", products);

        return ApiResponse.builder()
                .success(true)
                .message("All available products successfully retrieved")
                .data(products)
                .build();
    }

    @Override
    public ApiResponse deleteById(Long productId) {
        Products product = productsRepository.findById(productId).orElseThrow(()-> new RuntimeException());
        productsRepository.deleteProductsById(productId);
        log.info("Product with id " +productId+ " has been deleted {}", product);

        return ApiResponse.builder()
                .success(true)
                .message("Product with id " +productId+ " has been deleted")
                .build();
    }

    @Override
    public ApiResponse searchProductByName(String name) {
        List<Products> products = productsRepository.findByNameContaining(name);
        log.info("All products name containing " +name+ " successfully retrieved {}", products);

        return ApiResponse.builder()
                .success(true)
                .message("All products name containing " +name+ " successfully retrieved ")
                .data(products)
                .build();
    }
}
