package com.springboot.demo.controller;

import com.springboot.demo.entity.Department;
import com.springboot.demo.error.DepartmentNotFoundException;
import com.springboot.demo.service.DepartmentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class DepartmentContoller {

    private final Logger logger = LoggerFactory.getLogger(DepartmentContoller.class);
    @Autowired
    private DepartmentService departmentService;

    @PostMapping("/departments")
    public Department saveDepartment(@Valid @RequestBody Department department) {
        logger.info("inside saveDepartment method");
       return departmentService.saveDepartment(department);
    }
    @GetMapping("/departments")
    public List<Department> fetchDepartmentsList() {
        logger.info("inside fetchDepartmentsList method");
            return departmentService.fetchDepartmentsList();
    }

    @GetMapping("/departments/{id}")
    public  Department fetchDepartmentById(@PathVariable("id") Long id) throws DepartmentNotFoundException {
        logger.info("inside fetchDepartmentById method" + id);
        return departmentService.fetchDepartmentById(id);
    }

    @DeleteMapping("departments/{id}")
    public String deleteDepartmentById(@PathVariable("id") Long id) {
        departmentService.deleteDepartmentById(id);
        return "Delete record successfully";

    }
    @PutMapping("/departments/{id}")
    public Department updateDepartment(@PathVariable("id") Long departmentId, @RequestBody Department department) {

        return departmentService.updateDepartment(departmentId,department);
    }
    @GetMapping("departments/name/{name}")
    public Department fetchDepartmentByName(@PathVariable("name") String name) {

        return departmentService.fetchDepartmentByName(name);
    }

}
