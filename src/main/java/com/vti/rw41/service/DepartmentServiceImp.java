package com.vti.rw41.service;

import com.vti.rw41.dto.DepartmentRequest;
import com.vti.rw41.entity.DepartmentEntity;
import com.vti.rw41.exeption.ApiException;
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
        DepartmentEntity department = departmentRepository.findById(id).
                orElseThrow(() -> new ApiException("department.not.exists"));
        return Optional.of(department);
    }

    @Override
    public DepartmentEntity addDepartment(DepartmentRequest department) {
        DepartmentEntity departmentEntity = new DepartmentEntity();
        if (!departmentRepository.isDepartmentNameNotExists(department.getName())) {
            throw new ApiException("department.exists");
        }
        departmentEntity.setName(department.getName());
        return departmentRepository.save(departmentEntity);
    }

    @Override
    public Optional<DepartmentEntity> deleteDepartmentById(Integer id) {
        DepartmentEntity department = departmentRepository.findById(id)
                .orElseThrow(()-> new ApiException("department.not.exists"));
       departmentRepository.delete(department);
        return Optional.of(department);
    }


    public DepartmentEntity updateDepartmentById(Integer id, DepartmentRequest department) {
        DepartmentEntity oldDepartment = departmentRepository.findById(id)
                .orElseThrow(() -> new ApiException("department.not.exists"));
        oldDepartment.setName(department.getName());
        departmentRepository.save(oldDepartment);
        return oldDepartment;
    }

    @Override
    public DepartmentEntity getDepByName(String name) {
        DepartmentEntity department= departmentRepository.findByName(name);
        if(department== null){
            throw new ApiException("department.not.exists");
        }
        return departmentRepository.findByName(name);
    }

    public Page<DepartmentEntity> getDepByNameLike(String name, Pageable pageable) {
        return departmentRepository.findByNameLike(name, pageable);
    }
}