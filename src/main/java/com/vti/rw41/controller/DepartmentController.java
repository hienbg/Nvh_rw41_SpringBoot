package com.vti.rw41.controller;

import com.vti.rw41.dto.DepartmentRequest;
import com.vti.rw41.entity.Department;
import com.vti.rw41.service.DepartmentService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@Log4j2
@RestController // Nhan request tu client
@RequestMapping("/departments")
public class DepartmentController {

    //[R] GET /department --> Lay tat ca department
    //[R] GET /department/{id} --> Lay department theo id
    //[C] POST /department --> Tao moi department
    //[U] PUT /department{id} --> Update department theo id
    //[D] DELETE /department{id} --> Xoa department theo id


    @Autowired // Tu dong lay ra object
    // Bean (Object ) container,
    DepartmentService departmentService;

    @GetMapping
    public Page<Department> getAllDepartments(Pageable pageable) {
        return departmentService.getAllDepartments(pageable);
    }

    // @GetMapping("/{id}")
    @RequestMapping(value = "/id/{id}", method = RequestMethod.GET)
    public Optional<Department> getDepById(@PathVariable Integer id) {
        return departmentService.getDepById(id);
    }

    @RequestMapping(value = "/name/{name}", method = RequestMethod.GET)
    public Department getDepByName(@PathVariable String name) {
        return departmentService.getDepByName(name);
    }

    @RequestMapping(value = "/nameLike/{name}", method = RequestMethod.GET)
    public Page<Department> getDepByNameLike(String name, Pageable pageable) {
        return departmentService.getDepByNameLike(name, pageable);
    }

    // @PostMapping
    @RequestMapping(value = "", method = RequestMethod.POST)
    public Department addDepartment(@Valid @RequestBody DepartmentRequest department) {
        return departmentService.addDepartment(department);
    }

    //@DeleteMapping
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public Optional<Department> deleteDepartmentById(@PathVariable Integer id) {
        return departmentService.deleteDepartmentById(id);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public Optional<Department> updateDepartmentById(@PathVariable Integer id,
                                                     @Valid @RequestBody DepartmentRequest department) {
        return departmentService.updateDepartmentById(id, department);
    }


}
