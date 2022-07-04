package com.example.demo.services.impls;

import com.example.demo.entities.hotel;
import com.example.demo.entities.lodge;
import com.example.demo.repositories.hotelRepository;
import com.example.demo.services.hotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class hotelServiceImpl implements hotelService {

    @Autowired
    hotelRepository hotelRepo;

    @Override
    public hotel save(hotel entity) throws Exception {
        return hotelRepo.save(entity);
    }

    @Override
    public List<hotel> findAll() throws Exception {
        return hotelRepo.findAll();
    }

    @Override
    public Optional<hotel> findById(Long aLong) throws Exception {
        hotel hotel = hotelRepo.findById(aLong).orElse(null);
        return Optional.ofNullable(hotel);
    }

    @Override
    public hotel update(hotel entity) throws Exception {
        return hotelRepo.save(entity);
    }

    @Override
    public void deleteById(Long aLong) throws Exception {
        hotelRepo.deleteById(aLong);
    }
}
