package com.example.repository;
import com.example.model.LogData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface LogDataRepository extends JpaRepository<LogData, Long> {
}