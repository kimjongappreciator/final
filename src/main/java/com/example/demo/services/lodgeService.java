package com.example.demo.services;

import com.example.demo.entities.lodge;

import java.util.List;

public interface lodgeService extends CrudService<lodge,Long>{
    List<lodge> findByUserId(Long userId) throws Exception;
}
