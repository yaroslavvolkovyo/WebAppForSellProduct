package com.example.WebAppForSellProduct.repository;

import com.example.WebAppForSellProduct.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {
List<Product> findByName(String name);
}
