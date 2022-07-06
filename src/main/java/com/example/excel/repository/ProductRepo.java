package com.example.excel.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.excel.entity.Product;

@Repository
public interface ProductRepo extends JpaRepository<Product, Integer>{

}
