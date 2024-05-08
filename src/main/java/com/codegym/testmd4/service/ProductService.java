package com.codegym.testmd4.service;

import com.codegym.testmd4.model.Product;
import com.codegym.testmd4.repository.IProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ProductService implements IProductService{

    private final IProductRepository iProductRepository;

    @Override
    public List<Product> findAll() {
        return iProductRepository.findAll();
    }

    @Override
    public List<Product> findByName(String name) {
        return iProductRepository.findAllByNameContainingIgnoreCase(name);
    }

    @Override
    public void save(Product product) {
iProductRepository.save(product);
    }

    @Override
    public void deleteById(Long id) {
iProductRepository.deleteById(id);
    }

    @Override
    public Product getDetailProductBy(Long id) {
        return iProductRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("No product not found."));
    }
}
