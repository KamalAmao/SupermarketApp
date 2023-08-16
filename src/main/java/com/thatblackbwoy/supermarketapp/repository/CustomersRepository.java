package com.thatblackbwoy.supermarketapp.repository;

import com.thatblackbwoy.supermarketapp.model.Customers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface CustomersRepository extends JpaRepository<Customers, Long> {
    @Transactional
    void deleteById(Long customerId);

    @Transactional
    void deleteCustomersById(Long customerId);

    List<Customers> findByFirstnameContaining(String name);
}
