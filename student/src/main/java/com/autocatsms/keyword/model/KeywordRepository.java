package com.autocatsms.keyword.model;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.Optional;
@Repository
public interface KeywordRepository extends JpaRepository<KeywordTable,Long> {
    @Query("SELECT k FROM KeywordTable k WHERE k.id = ?1")
    Optional<KeywordTable> findKeywordById(Long id);
}
