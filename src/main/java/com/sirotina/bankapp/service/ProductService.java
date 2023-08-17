package com.sirotina.bankapp.service;

import com.sirotina.bankapp.entity.Product;
import com.sirotina.bankapp.service.exception.ProductNotFoundException;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface ProductService {

    List<Product> getAll();

    Product getProductById(UUID id) throws ProductNotFoundException;

    Product create(Product dto);

    Product editProductById(UUID id, Product dto) throws ProductNotFoundException;

    void deleteProductById(UUID id);

}
