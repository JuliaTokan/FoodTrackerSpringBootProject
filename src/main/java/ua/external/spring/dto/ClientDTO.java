package ua.external.spring.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ua.external.spring.entity.Activity;
import ua.external.spring.entity.Gender;
import ua.external.spring.entity.NutritionGoal;
import ua.external.spring.util.NutritionCalculator;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClientDTO {
    private Long id;

    @NotBlank(message = "Name may not be blank")
    @Size(min = 2, max = 32, message = "Name must be between 2 and 32 characters long")
    private String name;

    private Gender gender;

    //add
    private Integer age;
    //add
    private Double height;
    //add
    private Double weight;

    private NutritionGoal nutritionGoal;

    private Activity activity;

    private Integer calories;
    private Double protein;
    private Double fats;
    private Double carbohydrates;

    public static ClientDTO of (Long id, String name, Gender gender, Integer age, Double height, Double weight, NutritionGoal nutritionGoal, Activity activity, Integer calories, Double protein, Double fats, Double carbohydrates){
        return new ClientDTO(id, name, gender, age, height, weight, nutritionGoal, activity, calories, protein, fats, carbohydrates);
    }

    public void calculateNutritions(){
        Integer dailyCalories = NutritionCalculator.calculateCalories(gender, weight, height, age, activity, nutritionGoal);
        this.calories = dailyCalories;
        this.protein = NutritionCalculator.calculateProtein(nutritionGoal, dailyCalories);
        this.fats = NutritionCalculator.calculateFats(nutritionGoal, dailyCalories);
        this.carbohydrates = NutritionCalculator.calculateCarbohydrates(nutritionGoal, dailyCalories);
    }
}
