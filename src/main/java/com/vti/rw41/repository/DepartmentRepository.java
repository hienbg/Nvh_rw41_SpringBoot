package com.vti.rw41.repository;

import com.vti.rw41.entity.DepartmentEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepository extends JpaRepository<DepartmentEntity, Integer> {
    @Query("SELECT (count(d)=0) FROM DepartmentEntity d WHERE d.name =?1")
    boolean isDepartmentNameNotExists(String name);

    DepartmentEntity findByName(String name);

    @Query("SELECT d FROM DepartmentEntity d WHERE name LIKE %?1%")
    Page<DepartmentEntity> findByNameLike(String name, Pageable pageable);


}
