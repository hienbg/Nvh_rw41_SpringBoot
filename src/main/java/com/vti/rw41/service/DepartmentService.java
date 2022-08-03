package com.vti.rw41.service;

import com.vti.rw41.dto.DepartmentRequest;
import com.vti.rw41.entity.Department;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface DepartmentService {
    @Autowired
    Page<Department> getAllDepartments(Pageable pageable);

    Optional<Department> getDepById(Integer id);

    Department addDepartment(DepartmentRequest department);

    Optional<Department> deleteDepartmentById(Integer id);

    Optional<Department> updateDepartmentById(Integer id, DepartmentRequest department);

    Department getDepByName(String name);

    public Page<Department> getDepByNameLike(String name, Pageable pageable);
}
