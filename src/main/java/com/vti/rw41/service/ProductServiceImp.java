package com.vti.rw41.service;

import com.vti.rw41.dto.ProductRequest;
import com.vti.rw41.entity.ProductEntity;
import com.vti.rw41.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
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
    public Page<ProductEntity> getAllProduct(Pageable pageable) {
        return productRepository.findAll(pageable);
    }

    @Override
    public Optional<ProductEntity> getProductById(Integer id) {
        return productRepository.findById(id);
    }

    @Override
    public ProductEntity createProduct(ProductRequest inProduct) {
        ProductEntity product = new ProductEntity();
        product.setProductName(inProduct.getProductName());
        product.setCreatedDate(LocalDateTime.now());
        product.setUpdatedDate(LocalDateTime.now());
        product.setPrice(inProduct.getPrice());
        product.setStatus(inProduct.getStatus());

        return productRepository.save(product);
    }

    @Override
    public Optional<ProductEntity> deleteProductById(Integer id) {
        Optional<ProductEntity> product = productRepository.findById(id);
        product.ifPresent(p -> productRepository.delete(p));
        return product;

    }

    @Override
    public Optional<ProductEntity> updateProduct(Integer id, ProductRequest product) {
        Optional<ProductEntity> oldProduct = productRepository.findById(id);
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
