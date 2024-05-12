package com.example.TechShopWeb.services;

import com.example.TechShopWeb.repositories.ProductRepository;
import com.example.TechShopWeb.models.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Year;
import java.util.List;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    public void addProduct(Product product) {
        productRepository.save(product);
    }

    public List<Product> getAllProducts() {
        return productRepository.find();
    }

    public Product getById(int id) {
        return productRepository.findById(id).orElse(new Product());
    }

    public List<Product> getAllByContent(String text) {
        return productRepository.findByContent(text);
    }

    public List<Product> getByShelving(String shelving) {
        return productRepository.findByShelving(shelving);
    }

    // 'Old product' is a 10 years old from launch year
    public List<Product> getOldProducts() {
        int currentYear = Year.now().getValue();
        int past = currentYear - 10;
        return productRepository.findOldProducts(past);
    }
}
