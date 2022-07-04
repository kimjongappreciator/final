package com.example.demo.repositories;

import com.example.demo.entities.lodge;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface lodgeRepository extends JpaRepository<lodge, Long> {

    List<lodge> findByUserId(Long userId) throws Exception;
}
