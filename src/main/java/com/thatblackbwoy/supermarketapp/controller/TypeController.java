package com.thatblackbwoy.supermarketapp.controller;

import com.thatblackbwoy.supermarketapp.dto.TypeDto;
import com.thatblackbwoy.supermarketapp.dto.response.ApiResponse;
import com.thatblackbwoy.supermarketapp.service.TypeService;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class TypeController {
    private final TypeService typeService;

    @PostMapping("/type")
    public ResponseEntity<ApiResponse> createType(@RequestBody  TypeDto typeDto){
        try{
            return ResponseEntity.ok().body(typeService.createType(typeDto));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ApiResponse.builder().success(false).build());
        }
    }
    @PutMapping("/type/{typeId}")
    public ResponseEntity<ApiResponse> updateType(@PathVariable Long typeId, @RequestBody TypeDto typeDto){
        try{
            return ResponseEntity.ok().body(typeService.updateType(typeId, typeDto));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ApiResponse.builder().success(false).build());
        }
    }
    @GetMapping("/type")
    public ResponseEntity<ApiResponse> getAllType(){
        try{
            return ResponseEntity.ok().body(typeService.getAllType());
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ApiResponse.builder().success(false).build());
        }
    }
    @GetMapping("/search")
    public ResponseEntity<ApiResponse> search(@RequestParam  String name){
        try{
            return ResponseEntity.ok().body(typeService.searchTypeByName(name));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ApiResponse.builder().success(false).build());
        }
    }
}
