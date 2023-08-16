package com.thatblackbwoy.supermarketapp.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CustomersDto {
    private String firstname;
    private String lastname;
    private String email;

}
