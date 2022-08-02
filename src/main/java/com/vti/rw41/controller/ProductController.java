package com.vti.rw41.controller;

import com.vti.rw41.dto.ProductRequest;
import com.vti.rw41.entity.Department;
import com.vti.rw41.entity.Product;
import com.vti.rw41.service.ProductServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/products")
public class ProductController {
    @Autowired
    ProductServer server;
    @GetMapping
    public List<Product> getAllProduct() {
        return server.getAllProduct();
    }
    // @GetMapping("/{id}")
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Optional<Product> getProductById(@PathVariable Integer id) {
        return server.getProductById(id);
    }

    // @PostMapping
    @RequestMapping(value = "", method = RequestMethod.POST)
    public Product createProduct(@Valid @RequestBody ProductRequest inProduct) {
        return server.createProduct(inProduct);
    }

    //@DeleteMapping
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void deleteProductById(@PathVariable Integer id) {
        server.deleteProductById(id);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public Optional<Product> updateProduct(@PathVariable Integer id, @Valid @RequestBody ProductRequest product) {
        return server.updateProduct(id, product);
    }


}
