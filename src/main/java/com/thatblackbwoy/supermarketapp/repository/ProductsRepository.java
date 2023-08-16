package com.thatblackbwoy.supermarketapp.repository;

import com.thatblackbwoy.supermarketapp.model.Products;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface ProductsRepository extends JpaRepository<Products, Long> {
    @Transactional
    void deleteById(Long productId);

    @Transactional
    void deleteProductsById(Long productId);

    List<Products> findByNameContaining(String name);
}
