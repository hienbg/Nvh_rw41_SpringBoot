package com.vti.rw41.service;

import com.vti.rw41.dto.DepartmentRequest;
import com.vti.rw41.entity.Department;
import com.vti.rw41.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
//@Component
public class DepartmentServiceImp implements DepartmentService {

    @Autowired
    DepartmentRepository departmentRepository;

    @Override
    public List<Department> getAllDepartment() {
        return departmentRepository.findAll(Sort.by("id").descending());
    }
    @Override
    public Optional<Department> getDepById(Integer id) {
        return departmentRepository.findById(id);
    }
    @Override
    public Department addDepartment(DepartmentRequest department) {
        Department dep= new Department();
        dep.setName(department.getName());
        return departmentRepository.save(dep);
    }
    @Override
    public Optional<Department> deleteDepartmentById(Integer id) {
        Optional<Department> department = departmentRepository.findById(id);
        department.ifPresent(d -> departmentRepository.delete(d));
        return department;
    }


    public Optional<Department> updateDepartmentById(Integer id, DepartmentRequest department) {
        Optional<Department> oldDepartment = departmentRepository.findById(id);
        oldDepartment.ifPresent(d -> {
            d.setName(department.getName());
            departmentRepository.save(d);
        });
        return oldDepartment;
    }

    @Override
    public Department getDepByName(String name) {
        return departmentRepository.findByName(name);
    }
}