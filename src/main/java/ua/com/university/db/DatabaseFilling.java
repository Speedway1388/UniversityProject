package ua.com.university.db;

import ua.com.university.dao.DepartmentDao;
import ua.com.university.dao.DepartmentLectorDao;
import ua.com.university.dao.LectorDao;
import ua.com.university.dao.RankDao;
import ua.com.university.entity.Department;
import ua.com.university.entity.DepartmentLector;
import ua.com.university.entity.Lector;
import ua.com.university.entity.Rank;

public class DatabaseFilling {

    public void fillDb(final LectorDao lectorDao, final DepartmentDao departmentDao, final RankDao rankDao, final DepartmentLectorDao departmentLectorDao) {
        Lector user1 = new Lector("John", "Johnson",1l);
        Lector user2 = new Lector("Julie", "Jackson", 2l);
        Lector user3 = new Lector("Peter", "Parker", 2l);
        Lector user4 = new Lector("Mykyta", "Mykytiuk", 3l);
        lectorDao.save(user1);
        lectorDao.save(user2);
        lectorDao.save(user3);
        lectorDao.save(user4);
        Department department1 = new Department("Department1",1l);
        Department department2 = new Department("Department2",2l);
        departmentDao.save(department1);
        departmentDao.save(department2);

        Rank rank1 = new Rank("assistant",3000l);
        Rank rank2 = new Rank("associate professor",4000l);
        Rank rank3 = new Rank("professor",5000l);

        rankDao.save(rank1);
        rankDao.save(rank2);
        rankDao.save(rank3);

        DepartmentLector departmentLector1 = new DepartmentLector(1l,1l);
        DepartmentLector departmentLector2 = new DepartmentLector(1l,2l);
        DepartmentLector departmentLector3 = new DepartmentLector(2l,3l);
        DepartmentLector departmentLector4 = new DepartmentLector(2l,4l);
        DepartmentLector departmentLector5 = new DepartmentLector(1l,4l);

        departmentLectorDao.save(departmentLector1);
        departmentLectorDao.save(departmentLector2);
        departmentLectorDao.save(departmentLector3);
        departmentLectorDao.save(departmentLector4);
        departmentLectorDao.save(departmentLector5);
    }
}
