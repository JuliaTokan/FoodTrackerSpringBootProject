package ua.external.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.external.spring.entity.Gender;
import ua.external.spring.repository.GenderRepository;

import java.util.List;
import java.util.Optional;

@Service
public class GenderService {
    @Autowired
    GenderRepository genderRepository;

    public Optional<Gender> findGenderById(Long id){
        return genderRepository.findById(id);
    }

    public List<Gender> findAllGenders(){
        return genderRepository.findAll();
    }

    public boolean create(Gender gender){
        genderRepository.save(gender);
        return true;
    }
}
