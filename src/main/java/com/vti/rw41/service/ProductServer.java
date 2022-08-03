package com.vti.rw41.service;

import com.vti.rw41.dto.ProductRequest;
import com.vti.rw41.entity.ProductEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface ProductServer {
    @Autowired


    public Page<ProductEntity> getAllProduct(Pageable pageable);


    public Optional<ProductEntity> getProductById(Integer id);


    public ProductEntity createProduct(ProductRequest inProduct);

    public Optional<ProductEntity> deleteProductById(Integer id);

    public Optional<ProductEntity> updateProduct(Integer id, ProductRequest product) ;
}
