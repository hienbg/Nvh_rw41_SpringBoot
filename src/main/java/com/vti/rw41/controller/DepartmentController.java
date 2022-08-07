package com.vti.rw41.controller;

import com.vti.rw41.dto.DepartmentRequest;
import com.vti.rw41.entity.DepartmentEntity;
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
    public Page<DepartmentEntity> getAllDepartments(Pageable pageable) {
        return departmentService.getAllDepartments(pageable);
    }

    // @GetMapping("/{id}")
    @RequestMapping(value = "/id/{id}", method = RequestMethod.GET)
    public Optional<DepartmentEntity> getDepById(@PathVariable Integer id) {
        return departmentService.getDepById(id);
    }

    @RequestMapping(value = "/name/{name}", method = RequestMethod.GET)
    public DepartmentEntity getDepByName(@PathVariable String name) {
        return departmentService.getDepByName(name);
    }

    @RequestMapping(value = "/nameLike/{name}", method = RequestMethod.GET)
    public Page<DepartmentEntity> getDepByNameLike(@PathVariable String name, Pageable pageable) {
        return departmentService.getDepByNameLike(name, pageable);
    }

    // @PostMapping
    @RequestMapping(value = "", method = RequestMethod.POST)
    public DepartmentEntity addDepartment(@Valid @RequestBody DepartmentRequest department) {
        return departmentService.addDepartment(department);
    }

    //@DeleteMapping
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public Optional<DepartmentEntity> deleteDepartmentById(@PathVariable Integer id) {
        return departmentService.deleteDepartmentById(id);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public DepartmentEntity updateDepartmentById(@PathVariable Integer id,
                                                           @Valid @RequestBody DepartmentRequest department) {
        return departmentService.updateDepartmentById(id, department);
    }


}
