package com.vti.rw41.service;

import com.vti.rw41.dto.DepartmentRequest;
import com.vti.rw41.entity.DepartmentEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface DepartmentService {
    @Autowired
    Page<DepartmentEntity> getAllDepartments(Pageable pageable);

    Optional<DepartmentEntity> getDepById(Integer id);

    DepartmentEntity addDepartment(DepartmentRequest department);

    Optional<DepartmentEntity> deleteDepartmentById(Integer id);

    DepartmentEntity updateDepartmentById(Integer id, DepartmentRequest department);

    DepartmentEntity getDepByName(String name);

    public Page<DepartmentEntity> getDepByNameLike(String name, Pageable pageable);
}
