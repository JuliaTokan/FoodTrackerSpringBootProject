package ua.external.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.external.spring.entity.Activity;
import ua.external.spring.entity.EatPeriod;
import ua.external.spring.repository.ActivityRepository;
import ua.external.spring.repository.EatPeriodRepository;

import java.util.List;
import java.util.Optional;

@Service
public class EatPeriodService {
    @Autowired
    EatPeriodRepository eatPeriodRepository;

    public Optional<EatPeriod> findEatPeriodById(Long id){
        return eatPeriodRepository.findById(id);
    }

    public List<EatPeriod> findAllEatPeriods(){
        return eatPeriodRepository.findAll();
    }

    public boolean create(EatPeriod eatPeriod){
        eatPeriodRepository.save(eatPeriod);
        return true;
    }
}
