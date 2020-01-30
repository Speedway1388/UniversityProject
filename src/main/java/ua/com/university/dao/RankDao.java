package ua.com.university.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ua.com.university.entity.Rank;

@Repository
public interface RankDao extends JpaRepository<Rank, Long> {
    Rank getById(Long id);
}
