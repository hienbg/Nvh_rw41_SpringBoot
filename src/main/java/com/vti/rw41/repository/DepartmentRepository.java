package com.vti.rw41.repository;

import com.vti.rw41.entity.Department;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Integer> {
    @Query("SELECT (count(d)=0) FROM Department d WHERE d.name =?1")
    boolean isDepartmentNameNotExists(String name);

    Department findByName(String name);

    @Query("SELECT d FROM Department d WHERE name LIKE %?1%")
    Page<Department> findByNameLike(String name, Pageable pageable);


}
