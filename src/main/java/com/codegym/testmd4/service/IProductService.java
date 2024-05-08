package com.codegym.testmd4.service;

import com.codegym.testmd4.model.Product;

import java.util.List;

public interface IProductService {
    List<Product> findAll();
    List<Product> findByName(String name);
    void save(Product product);
    void deleteById(Long id);
    Product getDetailProductBy(Long id);;
}
