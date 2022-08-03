package com.vti.rw41.controller;

import com.vti.rw41.dto.ProductRequest;
import com.vti.rw41.entity.ProductEntity;
import com.vti.rw41.service.ProductServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@RestController
@RequestMapping("/products")
public class ProductController {
    @Autowired
    ProductServer server;

    @GetMapping
    public Page<ProductEntity> getAllProduct(Pageable pageable) {
        return server.getAllProduct(pageable);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Optional<ProductEntity> getProductById(@PathVariable Integer id) {
        return server.getProductById(id);
    }


    @RequestMapping(value = "", method = RequestMethod.POST)
    public ProductEntity createProduct(@Valid @RequestBody ProductRequest inProduct) {
        return server.createProduct(inProduct);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void deleteProductById(@PathVariable Integer id) {
        server.deleteProductById(id);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public Optional<ProductEntity> updateProduct(@PathVariable Integer id, @Valid @RequestBody ProductRequest product) {
        return server.updateProduct(id, product);
    }


}
