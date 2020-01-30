package ua.com.university.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.com.university.dao.DepartmentDao;
import ua.com.university.dao.LectorDao;
import ua.com.university.entity.Department;
import ua.com.university.entity.Lector;
import ua.com.university.service.DepartmentService;

import java.util.List;


@Service
@Transactional
public class DepartmentServiceImpl implements DepartmentService {

    @Autowired
    DepartmentDao departmentDao;
    @Autowired
    LectorDao lectorDao;

    public Lector getHeadOfDepartment(String name){
        return lectorDao.getById(
                departmentDao.getByName(name).getHead());
    }

    @Override
    public List<Department> getAllDepartments() {
        return departmentDao.findAllByNameIsNotNull();
//        return departmentDao.getAll();
//        return departmentDao.findAllWorkingDepartmentsByQuery();
    }

    public String getInfoAboutHeadOfDepartment(String name){
        Lector lector = getHeadOfDepartment(name);
        return lector.getName() + " " + lector.getSurName();
    }
    public String getDepartmentNameById(Long id){
        return departmentDao.getById(id).getName();
    }
    public Long getDepartmentIdByName(String name){
        return departmentDao.getByName(name).getId();
    }
}
