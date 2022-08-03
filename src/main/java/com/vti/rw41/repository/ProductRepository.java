package com.vti.rw41.repository;


import com.vti.rw41.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


@Repository
public interface ProductRepository extends JpaRepository<ProductEntity, Integer> {

    @Query("SELECT (count(p)=0) FROM ProductEntity p WHERE p.productName =?1")

    boolean isProductNameNotExists(String productName);
}
