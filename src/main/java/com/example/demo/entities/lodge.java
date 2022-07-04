package com.example.demo.entities;

import lombok.Data;

import javax.persistence.*;
import javax.validation.Valid;

import java.util.Date;

@Entity
@Table
@Data
public class lodge {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 50, nullable = true)
    private Long userId;
    @Column(nullable = true)
    private Date date = new Date();
    @Column(length = 50, nullable = true)
    private Integer nOfDays;
    @Column(length = 50, nullable = true)
    private Long hotelId;

    @Transient
    private hotel hotel;

}
