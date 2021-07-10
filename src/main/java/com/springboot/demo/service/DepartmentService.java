package com.springboot.demo.service;

import com.springboot.demo.entity.Department;
import com.springboot.demo.error.DepartmentNotFoundException;

import java.util.List;

public interface DepartmentService {
   public Department saveDepartment(Department department);

    public  List<Department> fetchDepartmentsList();


    public Department fetchDepartmentById(Long id) throws DepartmentNotFoundException;

    public void deleteDepartmentById(Long id);

 public Department updateDepartment(Long departmentId, Department department);

 public Department fetchDepartmentByName(String name);
}
