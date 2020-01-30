package ua.com.university.service;

import ua.com.university.entity.Department;
import ua.com.university.entity.Lector;

import java.util.List;

public interface DepartmentService {

    Lector getHeadOfDepartment(String name);
    List<Department> getAllDepartments();
    public String getDepartmentNameById(Long id);
    public Long getDepartmentIdByName(String name);
}
