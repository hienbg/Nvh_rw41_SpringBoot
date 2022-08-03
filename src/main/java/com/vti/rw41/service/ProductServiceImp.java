package com.vti.rw41.service;

import com.vti.rw41.dto.ProductRequest;
import com.vti.rw41.entity.Product;
import com.vti.rw41.enumurations.ProductStatus;
import com.vti.rw41.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImp implements ProductServer {

    @Autowired
    ProductRepository productRepository;

//    @PostConstruct
//    public void init() {
//        Product product = new Product();
//        for (int i = 0; i < 20; i++) {
//            product.setId((i + 1));
//            product.setProductName("product_" + (i + 1));
//            product.setPrice(0.99 + (i + 1));
//            product.setCreatedDate((LocalDateTime.now()));
//            product.setUpdatedDate((LocalDateTime.now()));
//            if (i % 2 == 0) {
//                product.setStatus(ProductStatus.ACTIVE);
//
//            } else {
//                product.setStatus(ProductStatus.INACTIVE);
//            }
//            productRepository.save(product);
//        }
//    }

    @Override
    public Page<Product> getAllProduct(Pageable pageable) {
        return productRepository.findAll(pageable);
    }

    @Override
    public Optional<Product> getProductById(Integer id) {
        return productRepository.findById(id);
    }

    @Override
    public Product createProduct(ProductRequest inProduct) {
        Product product = new Product();
        product.setProductName(inProduct.getProductName());
        product.setCreatedDate(inProduct.getCreatedDate());
        product.setUpdatedDate(inProduct.getUpdatedDate());
        product.setPrice(inProduct.getPrice());
        product.setStatus(inProduct.getStatus());

        return productRepository.save(product);
    }

    @Override
    public Optional<Product> deleteProductById(Integer id) {
        Optional<Product> product = productRepository.findById(id);
        product.ifPresent(p -> productRepository.delete(p));
        return product;

    }

    @Override
    public Optional<Product> updateProduct(Integer id, ProductRequest product) {
        Optional<Product> oldProduct = productRepository.findById(id);
        oldProduct.ifPresent(p -> {
            p.setProductName(product.getProductName());
            p.setCreatedDate(product.getCreatedDate());
            p.setUpdatedDate(product.getUpdatedDate());
            p.setPrice(product.getPrice());
            p.setStatus(product.getStatus());

            productRepository.save(p);
        });
        return oldProduct;
    }
}
