package com.example.TechShopWeb.controllers;

import com.example.TechShopWeb.models.Product;
import com.example.TechShopWeb.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }

    @PostMapping
    public void createProduct(@RequestBody Product product) {
        productService.addProduct(product);
    }

    @GetMapping("/{id}")
    public Product getProductById(@PathVariable("id") int id) {
        return productService.getById(id);
    }

    @GetMapping("/old")
    public List<Product> getOldProducts() {
        return productService.getOldProducts();
    }

    @GetMapping("/shelving/{shelving}")
    public List<Product> getAllByShelving(@PathVariable("shelving") String shelving) {
        return productService.getByShelving(shelving);
    }

    @GetMapping("/content/{text}")
    public List<Product> getByContent(@PathVariable("text") String text) {
        return productService.getAllByContent(text);
    }
}
