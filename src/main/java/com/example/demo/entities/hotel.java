package com.example.demo.entities;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table
@Data
public class hotel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 50, nullable = true)
    private String hotelName;
    @Column(length = 50, nullable = true)
    private String city;
    @Column(length = 50, nullable = true)
    private String room;


}
