package com.thatblackbwoy.supermarketapp.service.impl;

import com.thatblackbwoy.supermarketapp.dto.TypeDto;
import com.thatblackbwoy.supermarketapp.dto.response.ApiResponse;
import com.thatblackbwoy.supermarketapp.model.Type;
import com.thatblackbwoy.supermarketapp.repository.TypeRepository;
import com.thatblackbwoy.supermarketapp.service.TypeService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class TypeServiceImpl implements TypeService {
    private final TypeRepository typeRepository;
    @Override
    public ApiResponse createType(TypeDto typeDto) {
        Type type = Type.builder()
                .name(typeDto.getName())
                .description(typeDto.getDescription())
                .build();

        Type response = typeRepository.save(type);
        log.info("Type successfully created {}", response);

        return ApiResponse.builder()
                .success(true)
                .message("Type successfully created")
                .data(response)
                .build();
    }

    @Override
    public ApiResponse updateType(Long typeId, TypeDto typeDto) {
        Type type = typeRepository.findById(typeId).orElseThrow(()-> new RuntimeException());
        type.setName(typeDto.getName());
        type.setDescription(typeDto.getDescription());

        Type response = typeRepository.save(type);
        log.info("Type with id " +typeId+ " updated successfully {}", response);

        return ApiResponse.builder()
                .success(true)
                .message("Type with id " +typeId+ " updated successfully")
                .build();

    }

    @Override
    public ApiResponse getAllType() {
       List<Type> type = typeRepository.findAll();
       log.info("All available type successfully retrieved {}", type);

       return ApiResponse.builder()
               .success(true)
               .message("All available type retrieved successfully retrieved")
               .data(type)
               .build();
    }

    @Override
    public ApiResponse searchTypeByName(String name) {
       List<Type> types = typeRepository.findByNameContaining(name);
       log.info("All type names containing " +name+ " successfully retrieved {}", types);

       return ApiResponse.builder()
               .success(true)
               .message("All type names containing " +name+ " successfully retrieved")
               .data(types)
               .build();
    }
}
