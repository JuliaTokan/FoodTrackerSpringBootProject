package ua.external.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.external.spring.entity.NutritionGoal;
import ua.external.spring.repository.NutritionGoalRepository;

import java.util.List;
import java.util.Optional;

@Service
public class NutritionGoalService {
    @Autowired
    NutritionGoalRepository nutritionGoalRepository;

    public Optional<NutritionGoal> findNutritionGoalById(Long id){
        return nutritionGoalRepository.findById(id);
    }

    public List<NutritionGoal> findAllNutritionGoals(){
        return nutritionGoalRepository.findAll();
    }

    public boolean create(NutritionGoal nutritionGoal){
        nutritionGoalRepository.save(nutritionGoal);
        return true;
    }
}
