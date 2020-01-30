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

    @Query(value = "SELECT * from lector l where l.name like %:search_word% or l.sur_name like %:search_word%",nativeQuery = true)
    List<Lector> searchForLectors(@Param("search_word") String searchword);



}
