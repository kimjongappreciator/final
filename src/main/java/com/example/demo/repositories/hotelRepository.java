package com.example.demo.repositories;

import com.example.demo.entities.hotel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface hotelRepository extends JpaRepository<hotel,Long> {
}
