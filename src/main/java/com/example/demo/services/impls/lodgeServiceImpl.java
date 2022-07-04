package com.example.demo.services.impls;

import com.example.demo.entities.lodge;
import com.example.demo.repositories.lodgeRepository;
import com.example.demo.services.lodgeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class lodgeServiceImpl implements lodgeService {

    @Autowired
    lodgeRepository lodgerepo;

    @Override
    public lodge save(lodge entity) throws Exception {
        return lodgerepo.save(entity);
    }

    @Override
    public List<lodge> findAll() throws Exception {
        return lodgerepo.findAll();
    }

    @Override
    public Optional<lodge> findById(Long aLong) throws Exception {
        lodge lodge = lodgerepo.findById(aLong).orElse(null);
        return Optional.ofNullable(lodge);
    }

    @Override
    public lodge update(lodge entity) throws Exception {
        return lodgerepo.save(entity);
    }

    @Override
    public void deleteById(Long aLong) throws Exception {
        lodgerepo.deleteById(aLong);
    }

    @Override
    public List<lodge> findByUserId(Long userId) throws Exception {
        return lodgerepo.findByUserId(userId);
    }
}
