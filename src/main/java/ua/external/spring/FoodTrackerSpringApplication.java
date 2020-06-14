package ua.external.spring;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;
import org.springframework.web.servlet.view.JstlView;
import org.springframework.web.servlet.view.UrlBasedViewResolver;
import ua.external.spring.entity.*;
import ua.external.spring.repository.UserRepository;
import ua.external.spring.service.*;

import java.util.Locale;

@SpringBootApplication
public class FoodTrackerSpringApplication {

    public static void main(String[] args) {
        SpringApplication.run(FoodTrackerSpringApplication.class, args);
    }

    @Bean
    public UrlBasedViewResolver setupViewResolver() {
        UrlBasedViewResolver resolver = new UrlBasedViewResolver();
        resolver.setPrefix("/pages/");
        resolver.setSuffix(".html");
        resolver.setViewClass(JstlView.class);

        return resolver;
    }



    /*@Bean
    public CommandLineRunner addGender(final GenderService service) {
        return new CommandLineRunner() {
            @Override
            public void run(String... strings) throws Exception {
                service.create(new Gender("Female"));
                service.create(new Gender("Male"));
            }
        };
    }

    @Bean
    public CommandLineRunner addRole(final UserRoleService service) {
        return new CommandLineRunner() {
            @Override
            public void run(String... strings) throws Exception {
                service.create(new UserRole("USER"));
                service.create(new UserRole("ADMIN"));
            }
        };
    }

    @Bean
    public CommandLineRunner addActivity(final ActivityService service) {
        return new CommandLineRunner() {
            @Override
            public void run(String... strings) throws Exception {
                service.create(new Activity("High", 1.9));
                service.create(new Activity("Medium", 1.5));
                service.create(new Activity("Low", 1.2));
            }
        };
    }

    @Bean
    public CommandLineRunner addNutrGoal(final NutritionGoalService service) {
        return new CommandLineRunner() {
            @Override
            public void run(String... strings) throws Exception {
                service.create(new NutritionGoal("Weight Lost", 0.9));
                service.create(new NutritionGoal("Weight Maintenance", 1.0));
                service.create(new NutritionGoal("Weight Gain", 1.1));
            }
        };
    }

    @Bean
    public CommandLineRunner addEatPeriod(final EatPeriodService service) {
        return new CommandLineRunner() {
            @Override
            public void run(String... strings) throws Exception {
                service.create(new EatPeriod("Breakfast"));
                service.create(new EatPeriod("Lunch"));
                service.create(new EatPeriod("Snack"));
                service.create(new EatPeriod("Supper"));
            }
        };
    }*/

    /*@Bean
    public CommandLineRunner addEatPeriod(final UserService userService, final UserRoleService userRoleService, final UserRepository userRepository) {
        return new CommandLineRunner() {
            @Override
            public void run(String... strings) throws Exception {
                User user = userService.findUserByLogin("test.user@gmail.com").get();
                UserRole userRole = userRoleService.findUserRoleByName("ADMIN").get();
                user.setRole(userRole);
                userRepository.save(user);
            }
        };
    }*/

}
