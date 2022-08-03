package com.vti.rw41.service;

import com.vti.rw41.dto.DepartmentRequest;
import com.vti.rw41.entity.DepartmentEntity;
import com.vti.rw41.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
//@Component
public class DepartmentServiceImp implements DepartmentService {

    @Autowired
    DepartmentRepository departmentRepository;

//    @PostConstruct
//    public void init() {
//        Department department = new Department();
//        for (int i = 0; i < 50; i++) {
//            department.setId((i + 1));
//            department.setName("department_" + (i + 1));
//            departmentRepository.save(department);
//        }
//    }

    @Override
    public Page<DepartmentEntity> getAllDepartments(Pageable pageable) {
        return departmentRepository.findAll(pageable);
    }

    @Override
    public Optional<DepartmentEntity> getDepById(Integer id) {
        return departmentRepository.findById(id);
    }

    @Override
    public DepartmentEntity addDepartment(DepartmentRequest department) {
        DepartmentEntity dep = new DepartmentEntity();
        dep.setName(department.getName());
        return departmentRepository.save(dep);
    }

    @Override
    public Optional<DepartmentEntity> deleteDepartmentById(Integer id) {
        Optional<DepartmentEntity> department = departmentRepository.findById(id);
        department.ifPresent(d -> departmentRepository.delete(d));
        return department;
    }


    public Optional<DepartmentEntity> updateDepartmentById(Integer id, DepartmentRequest department) {
        Optional<DepartmentEntity> oldDepartment = departmentRepository.findById(id);
        oldDepartment.ifPresent(d -> {
            d.setName(department.getName());
            departmentRepository.save(d);
        });
        return oldDepartment;
    }

    @Override
    public DepartmentEntity getDepByName(String name) {
        return departmentRepository.findByName(name);
    }

    public Page<DepartmentEntity> getDepByNameLike(String name, Pageable pageable) {
        return departmentRepository.findByNameLike(name, pageable);
    }
}