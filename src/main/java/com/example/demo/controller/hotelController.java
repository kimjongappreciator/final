package com.example.demo.controller;

import com.example.demo.entities.hotel;
import com.example.demo.services.hotelService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Slf4j
@RestController
@RequestMapping("/hotel")
public class hotelController {

    @Autowired
    private hotelService hservice;

    @GetMapping(path = "/id/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<hotel> fetchById(@PathVariable("id") Long id) {
        try {
            Optional<hotel> optionalHotel = hservice.findById(id);
            if(optionalHotel.isPresent()) {
                return new ResponseEntity<hotel>(optionalHotel.get(), HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping
    public ResponseEntity<hotel> save(@Valid @RequestBody hotel hotel, BindingResult result) {

        try {
            hotel hotelCreate = hservice.save(hotel);
            return ResponseEntity.status(HttpStatus.CREATED).body(hotelCreate);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<hotel> update(@PathVariable("id") Long id, @RequestBody hotel hotel) {

        try {
            Optional<hotel> optionalHotel = hservice.findById(id);
            if (optionalHotel.isPresent()) {
                hotel hotelCreate = hservice.save(hotel);
                return ResponseEntity.status(HttpStatus.CREATED).body(hotelCreate);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<hotel> deleteById(@PathVariable("id") Long id) {


        try {
            Optional<hotel> optionalCard = hservice.findById(id);
            if (optionalCard.isPresent()) {
                hservice.deleteById(id);
                return new ResponseEntity<hotel>(HttpStatus.OK);
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
