package com.codegym.testmd4.service;

import com.codegym.testmd4.model.TypeProduct;
import com.codegym.testmd4.repository.ITypeProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@AllArgsConstructor
public class TypeProductService implements ITypeProductService {
    ITypeProductRepository iTypeProduct;
    @Override
    public List<TypeProduct> getAllTypeProduct() {
        return iTypeProduct.findAll();
    }
}
