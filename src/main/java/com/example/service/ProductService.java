package com.example.service;

import com.example.entity.Product;
import com.example.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    private final ProductRepository repository;

    public ProductService(ProductRepository repository) {
        this.repository = repository;
    }

    public Product saveProduct(Product product){
        return repository.save(product);
    }

    public List<Product> getAllProducts(){
        return repository.findAll();
    }

    public Product getProductById(Integer id){
        return repository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Product not found with id " + id));
    }

    public Product updateProduct(Integer id, Product product){

        Product existing = repository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Product not found"));

        existing.setName(product.getName());
        existing.setPrice(product.getPrice());

        return repository.save(existing);
    }

    public String deleteProduct(Integer id){

        Product product = repository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Product not found"));

        repository.delete(product);

        return "Product deleted successfully";
    }
}