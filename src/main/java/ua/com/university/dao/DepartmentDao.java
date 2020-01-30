package ua.com.university.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ua.com.university.entity.Department;

import java.util.List;

@Repository
public interface DepartmentDao extends JpaRepository<Department, Long> {

    Department getByName(String name);
    Department getById(Long id);
//    List<Department> getAll();
    List<Department> findAllByNameIsNotNull();
//    @Query("select u from department u")
    @Query(value = "SELECT **  FROM DEPARTMENT u",
            nativeQuery = true)
    List<Department> findAllWorkingDepartmentsByQuery();
}
