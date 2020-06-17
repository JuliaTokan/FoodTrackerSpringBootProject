package ua.external.spring.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.external.spring.entity.Gender;
import ua.external.spring.repository.GenderRepository;
import ua.external.spring.service.IGenderService;

import java.util.List;
import java.util.Optional;

@Service
public class GenderService implements IGenderService {
    @Autowired
    GenderRepository genderRepository;

    @Override
    public Optional<Gender> findGenderById(Long id){
        return genderRepository.findById(id);
    }

    @Override
    public List<Gender> findAllGenders(){
        return genderRepository.findAll();
    }

    @Override
    public boolean create(Gender gender){
        genderRepository.save(gender);
        return true;
    }
}
