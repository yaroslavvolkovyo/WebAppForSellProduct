package com.example.WebAppForSellProduct.service;

import com.example.WebAppForSellProduct.model.Product;
import com.example.WebAppForSellProduct.repository.ProductRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.awt.color.ProfileDataException;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public Product getProductById(Long id) {
        return productRepository.findById(id).orElse(null);
    }
    public List<Product> getProductByName(String name) {
        if(name!=null) {
            productRepository.findByName(name);
        }
        return null;
    }
    public Product saveProduct(Product product) {
        return productRepository.save(product);
    }

    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }

//    public Product updateProduct(Long id, Product updatedProduct) {
//        Optional<Product> existingProductOptional = productRepository.findById(id);
//        if (existingProductOptional.isPresent()) {
//            Product existingProduct = existingProductOptional.get();
//            existingProduct.setName(updatedProduct.getName());
//            existingProduct.setPrice(updatedProduct.getPrice());
//            existingProduct.setDescription(updatedProduct.getDescription());
//            existingProduct.setAuthor(updatedProduct.getAuthor());
//            existingProduct.setCity(updatedProduct.getCity());
//            return productRepository.save(existingProduct);
//        }else {
//            // Если продукт не найден, выбрасываем исключение или возвращаем null
//            throw new EntityNotFoundException("Product with id " + id + " not found");
//        }
//
//    }
}
