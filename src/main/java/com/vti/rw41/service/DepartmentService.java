package com.vti.rw41.service;

import com.vti.rw41.dto.DepartmentRequest;
import com.vti.rw41.entity.Department;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public interface DepartmentService {
    @Autowired
    List<Department> getAllDepartment();

    Optional<Department> getDepById(Integer id);

    Department addDepartment(DepartmentRequest department);

    Optional<Department> deleteDepartmentById(Integer id);

    Optional<Department> updateDepartmentById(Integer id, DepartmentRequest department);

    Department getDepByName(String name);
}
