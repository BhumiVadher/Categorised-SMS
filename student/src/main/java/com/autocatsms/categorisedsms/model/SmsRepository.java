package com.autocatsms.categorisedsms.model;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
@Repository
public  interface SmsRepository extends JpaRepository<CategorisedSms,Long> {
    @Query("SELECT s FROM CategorisedSms s WHERE s.id = ?1")
    CategorisedSms findSmsById(Long id);
}