package com.codegym.testmd4.repository;

import com.codegym.testmd4.model.TypeProduct;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ITypeProductRepository extends JpaRepository<TypeProduct, Long> {
}
