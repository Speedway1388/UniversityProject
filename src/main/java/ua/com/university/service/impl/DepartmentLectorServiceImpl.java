package ua.com.university.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.com.university.dao.DepartmentDao;
import ua.com.university.dao.DepartmentLectorDao;
import ua.com.university.dao.LectorDao;
import ua.com.university.dao.RankDao;
import ua.com.university.entity.DepartmentLector;
import ua.com.university.entity.Lector;
import ua.com.university.service.DepartmentLectorService;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

@Service
@Transactional
public class DepartmentLectorServiceImpl implements DepartmentLectorService {


    @Autowired
    DepartmentDao departmentDao;
    @Autowired
    LectorDao lectorDao;
    @Autowired
    RankDao rankDao;
    @Autowired
    DepartmentLectorDao departmentLectorDao;

    public Integer getCountOfEmployeeForDepartment(String name){
        return departmentLectorDao.countByDepartmentId(
                departmentDao.getByName(name).getId());

    }
    public Map<String, Integer> getRankCountByDepartment(Long depId){
        List<DepartmentLector> allByDepartmentId = getAllByDepartmentId(depId);
        Iterator<DepartmentLector> iterator = allByDepartmentId.iterator();
        Map<String, Integer> map = new HashMap<String, Integer>();
        while (iterator.hasNext()){
            DepartmentLector next = iterator.next();
            String name = rankDao.getById(
                    lectorDao.getById(
                            next.getLectorId())
                            .getRankId()).getName();
            if(!map.containsKey(name)){
                map.put(name,1);
            }else {
                map.put(name,map.get(name)+1);
            }
        }
        return map;
    }
    public Long getAverageSalaryForDepartment(Long depId){
        List<DepartmentLector> allByDepartmentId = getAllByDepartmentId(depId);
        Iterator<DepartmentLector> iterator = allByDepartmentId.iterator();
        long sumOfSalary = 0L;
        int count = allByDepartmentId.size();
        while (iterator.hasNext()){
            DepartmentLector next = iterator.next();
            Long rankId = lectorDao.getById(next.getLectorId()).getRankId();
            sumOfSalary += rankDao.getById(rankId).getSalary();
        }
        return sumOfSalary / count;
    }

    @Override
    public List<Lector> findByKeyWord(String template) {
        return lectorDao.searchForLectors(template);
    }

    private List<DepartmentLector> getAllByDepartmentId(Long depId){
        return departmentLectorDao.getAllByDepartmentId(depId);
    }

}
