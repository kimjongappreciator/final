package com.example.demo.controller;

import com.example.demo.entities.hotel;
import com.example.demo.entities.lodge;
import com.example.demo.services.lodgeService;
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
@RequestMapping("/lodge")
public class lodgeController {
    @Autowired
    private lodgeService lservice;
    @GetMapping(path = "/id/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<lodge> fetchById(@PathVariable("id") Long id) {
        try {
            Optional<lodge> optionalCard = lservice.findById(id);
            if(optionalCard.isPresent()) {
                return new ResponseEntity<lodge>(optionalCard.get(), HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping(path = "/user-id/{userid}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<lodge>> getByHomieId(@PathVariable("userid") Long userid) throws Exception {

        List<lodge> lodges = lservice.findByUserId(userid);
        if ( null == lodges ) {
            log.error("Cards with homie id {} not found.", lodges);
            return  ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(lodges);
    }

    @PostMapping
    public ResponseEntity<lodge> save(@Valid @RequestBody lodge lodge, BindingResult result) {

        try {
            lodge lodgeCreate = lservice.save(lodge);
            return ResponseEntity.status(HttpStatus.CREATED).body(lodgeCreate);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<lodge> update(@PathVariable("id") Long id, @RequestBody lodge lodge) {

        try {
            Optional<lodge> optionalCard = lservice.findById(id);
            if (optionalCard.isPresent()) {
                lodge lodgeCreate = lservice.save(lodge);
                return ResponseEntity.status(HttpStatus.CREATED).body(lodgeCreate);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<lodge> deleteById(@PathVariable("id") Long id) {


        try {
            Optional<lodge> optionalCard = lservice.findById(id);
            if (optionalCard.isPresent()) {
                lservice.deleteById(id);
                return new ResponseEntity<lodge>(HttpStatus.OK);
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
