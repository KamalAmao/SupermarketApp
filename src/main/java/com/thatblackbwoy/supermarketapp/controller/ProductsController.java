package com.thatblackbwoy.supermarketapp.controller;

import com.thatblackbwoy.supermarketapp.dto.ProductsDto;
import com.thatblackbwoy.supermarketapp.dto.response.ApiResponse;
import com.thatblackbwoy.supermarketapp.service.ProductsService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class ProductsController {
    private final ProductsService productsService;

    @PostMapping("/product{typeId}")
    public ResponseEntity<ApiResponse> addProduct(@PathVariable Long typeId, @RequestBody ProductsDto productsDto){
        try{
            return ResponseEntity.ok().body(productsService.addProduct(typeId, productsDto));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ApiResponse.builder().success(false).build());
        }
    }
    @PutMapping("/product{productId}")
    public ResponseEntity<ApiResponse> updateProduct(@PathVariable Long productId, @RequestBody ProductsDto productsDto){
        try{
            return ResponseEntity.ok().body(productsService.updateProduct(productId, productsDto));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ApiResponse.builder().success(false).build());
        }
    }
    @GetMapping("/{productId}")
    public ResponseEntity<ApiResponse> getById(@PathVariable Long productId){
        try{
            return ResponseEntity.ok().body(productsService.getById(productId));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(ApiResponse.builder().success(false).build());
        }
    }
    @GetMapping("/products")
    public ResponseEntity<ApiResponse> getAllProducts(){
        try{
            return ResponseEntity.ok().body(productsService.getAllProducts());
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(ApiResponse.builder().success(false).build());
        }
    }
    @DeleteMapping("/product{productId}")
    public ResponseEntity<ApiResponse> deleteProductById(@PathVariable Long productId){
        try{
            return ResponseEntity.ok().body(productsService.deleteById(productId));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ApiResponse.builder().success(false).build());
        }
    }
    @GetMapping("/search/product")
    public ResponseEntity<ApiResponse> searchProductContainingNameLike(@RequestParam String name){
        try{
            return ResponseEntity.ok().body(productsService.searchProductByName(name));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ApiResponse.builder().success(false).build());
        }
    }
}
