package ua.com.university.service;

import ua.com.university.entity.Lector;

import java.util.List;
import java.util.Map;

public interface DepartmentLectorService {
    Integer getCountOfEmployeeForDepartment(String name);
    public Map<String, Integer> getRankCountByDepartment(Long id);
    public Long getAverageSalaryForDepartment(Long depId);
    public List<Lector> findByKeyWord(String template);
}
