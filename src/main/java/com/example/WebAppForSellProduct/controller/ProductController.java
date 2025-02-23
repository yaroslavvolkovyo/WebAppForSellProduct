package com.example.WebAppForSellProduct.controller;


import com.example.WebAppForSellProduct.model.Product;
import com.example.WebAppForSellProduct.service.ProductService;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/api/products")
public class ProductController {

    @Autowired
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/get/{name}")
    public List<Product> getProduct(@PathVariable String name){
        return productService.getProductByName(name);
    }

//    @PutMapping("/save/{id}")
//    public ResponseEntity<Product> updateProduct(@PathVariable Long id, @RequestBody Product updatedProduct) {
//        try {
//            Product updated = productService.updateProduct(id, updatedProduct);
//            return ResponseEntity.ok(updated); // Возвращаем обновленный продукт
//        } catch (EntityNotFoundException e) {
//            return ResponseEntity.notFound().build(); // Возвращаем 404 Not Found
//        }
//    }todo

    @GetMapping("/get")
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }

    @PostMapping("/save")
    public Product createProduct(@RequestBody Product product) {
        return productService.saveProduct(product);
    }

    @GetMapping("/get/{id}")
    public Product getProduct(@PathVariable Long id) {
        return productService.getProductById(id);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteProduct(@PathVariable Long id) {
        productService.deleteProduct(id);
    }







}
