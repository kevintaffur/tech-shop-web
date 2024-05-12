package com.example.TechShopWeb.repositories;

import com.example.TechShopWeb.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {
    @Query(value = "select * from products", nativeQuery = true)
    List<Product> find();

//    @Query(value = "select * from products where product_id=:id", nativeQuery = true)
//    Product findUsingId(@Param("id") int id);

    @Query(value = "select * from products where " +
            "name like %:txt% or name like %:txt or name like :txt% or " +
            "type like %:txt% or type like %:txt or type like :txt% or " +
            "shelving like %:txt% or shelving like %:txt or shelving like :txt%",
            nativeQuery = true)
    List<Product> findByContent(@Param("txt") String txt);

//    @Query(value = "select * from products where shelving=:shelving", nativeQuery = true)
    List<Product> findByShelving(String shelving);

    @Query(value = "select * from products where launch_year<:past", nativeQuery = true)
    List<Product> findOldProducts(@Param("past") int past);
}
