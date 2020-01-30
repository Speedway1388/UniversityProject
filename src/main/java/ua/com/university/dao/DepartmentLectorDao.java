package ua.com.university.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ua.com.university.entity.DepartmentLector;

import java.util.List;

@Repository
public interface DepartmentLectorDao extends JpaRepository<DepartmentLector, Long> {

    Integer countByDepartmentId (Long id);
    List<DepartmentLector> getAllByDepartmentId(Long id);
    //    @Query(value = "SELECT u FROM User u ORDER BY id")
//    Page<User> findAllUsersWithPagination(Pageable pageable);

}
