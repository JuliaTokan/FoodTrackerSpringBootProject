package ua.external.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.external.spring.dto.MealsDTO;
import ua.external.spring.dto.UserDTO;
import ua.external.spring.entity.Meals;
import ua.external.spring.entity.Product;
import ua.external.spring.entity.User;
import ua.external.spring.repository.ProductRepository;
import ua.external.spring.repository.UserRepository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private MealsService mealsService;

    @Transactional
    public boolean createUser(UserDTO user){
        if (userRepository.existsByLogin(user.getLogin()))
            return false;

        userRepository.save(User.fromDTO(user));
        return true;
    }

    public boolean updateUser(User user){
        userRepository.save(user);
        return true;
    }

    @Transactional(readOnly = true)
    public Optional<User> findUserByLogin(String login){
        return userRepository.findByLogin(login);
    }

    public Integer countCalories(User user) {
        List<MealsDTO> meals =mealsService.getAllMealForUserByDate(user.getId(), LocalDate.now());
        Integer numOfCalories = meals.stream().mapToInt(x -> x.getProduct().getCalories() * x.getWeight() / 100).sum();
        return numOfCalories;
    }

    public Integer countProtein(User user) {
        List<MealsDTO> meals =mealsService.getAllMealForUserByDate(user.getId(), LocalDate.now());
        Integer numOfProtein = meals.stream().mapToInt(x -> x.getProduct().getProtein().intValue() * x.getWeight() / 100).sum();
        return numOfProtein;
    }

    public Integer countFats(User user) {
        List<MealsDTO> meals =mealsService.getAllMealForUserByDate(user.getId(), LocalDate.now());
        Integer numOfFats = meals.stream().mapToInt(x -> x.getProduct().getFats().intValue() * x.getWeight() / 100).sum();
        return numOfFats;
    }

    public Integer countCarbohydrates(User user) {
        List<MealsDTO> meals =mealsService.getAllMealForUserByDate(user.getId(), LocalDate.now());
        Integer numOfCarbohydrates = meals.stream().mapToInt(x -> x.getProduct().getCarbohydrates().intValue() * x.getWeight() / 100).sum();
        return numOfCarbohydrates;
    }
}
