package ua.com.university.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ua.com.university.entity.Lector;

import java.util.List;

@Repository
public interface LectorDao extends JpaRepository<Lector, Long> {
    Lector getById(Long id);

//    @Query("select name, sur_name from university.lector\n" +
//            "where name like '%so%' or sur_name like '%searchword%'")
    @Query("SELECT e from lector e where e.name like %:search_word% or e.surName like %:search_word%")
    List<Lector> searchForLectors(@Param("search_word") String searchword);



}
