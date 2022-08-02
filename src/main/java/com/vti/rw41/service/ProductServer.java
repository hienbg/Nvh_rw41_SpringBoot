package com.vti.rw41.service;

import com.vti.rw41.dto.ProductRequest;
import com.vti.rw41.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

public interface ProductServer {
    @Autowired


    public List<Product> getAllProduct();


    public Optional<Product> getProductById(Integer id);


    public Product createProduct(ProductRequest inProduct);

    public Optional<Product> deleteProductById(Integer id);

    public Optional<Product> updateProduct(Integer id, ProductRequest product) ;
}
