package ua.external.spring.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ua.external.spring.dto.MealsDTO;
import ua.external.spring.dto.ProductDTO;
import ua.external.spring.entity.Client;
import ua.external.spring.entity.EatPeriod;
import ua.external.spring.entity.Product;
import ua.external.spring.entity.User;
import ua.external.spring.service.impl.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

import static ua.external.spring.util.сonst.Constant.*;
import static ua.external.spring.util.сonst.Pages.*;

@Controller
@RequestMapping(value = "/user")
public class UserController {
    @Autowired
    private UserService userService;

    @Autowired
    private ProductService productService;

    @Autowired
    private MealsService mealsService;

    @Autowired
    private EatPeriodService eatPeriodService;

    @Autowired
    private EmailService emailService;

    final static Logger logger = LogManager.getLogger();
    final static int WEEK = 7;

    @GetMapping(value = "/meals")
    public String getMealsPage(HttpSession session, Model model) {
        return MEALS_PAGE;
    }

    @GetMapping(value = "/progress")
    public String getProgressPage(HttpSession session, Model model) {
        User user = null;
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (principal instanceof UserDetails) {
            String email = ((UserDetails) principal).getUsername();
            user = userService.findUserByLogin(email).get();
        }

        LocalDate cur_date = LocalDate.now();
        HashMap<String, Integer> weekInfo = new LinkedHashMap<>();

        for (int i = 0; i < WEEK; i++) {
            LocalDate date = cur_date.minusDays(i);
            List<MealsDTO> meals = mealsService.getAllMealForUserByDate(user.getId(), date);
            Integer numOfCalories = meals.stream().mapToInt(x -> x.getProduct().getCalories() * x.getWeight() / 100).sum();
            weekInfo.put(date.toString(), numOfCalories);
        }
        try {
            ObjectMapper mapper = new ObjectMapper();
            model.addAttribute(PARAM_WEEK_INFO, mapper.writeValueAsString(weekInfo));
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        return PROGRESS_PAGE;
    }

    @PostMapping(value = "/product")
    public String product(HttpServletRequest request, @Valid ProductDTO product) {
        Boolean isPublic = request.getParameter(PARAM_PUBLIC) == null ? false : request.getParameter(PARAM_PUBLIC).equals("on") ? true : false;
        product.setCommon(isPublic);
        product.setDeleted(false);

        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (principal instanceof UserDetails) {
            String email = ((UserDetails) principal).getUsername();
            User user = userService.findUserByLogin(email).get();
            product.setUser(user);
            productService.createProduct(product);
            logger.info("create product with id = " + product.getId());
        }

        String referer = request.getHeader("Referer");
        return "redirect:" + referer;
    }

    @PostMapping(value = "/meals/delete")
    public String deleteMeals(@RequestParam(name = "toDelete[]") String[] textIds) {
        if (textIds != null) {
            for (String textId : textIds) {
                Long id = Long.parseLong(textId);
                mealsService.deleteMealsById(id);
                logger.info("delete product with id = " + id);
            }
        }
        return MEALS_PAGE;
    }

    @PostMapping(value = "/meals")
    public String addMeals(HttpServletRequest request, @Valid MealsDTO meals) {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (principal instanceof UserDetails) {
            String email = ((UserDetails) principal).getUsername();
            User user = userService.findUserByLogin(email).get();
            meals.setUser(user);
            buildMeals(request, meals);
            mealsService.createMeals(meals);
            checkCaloriesLimit(user);
            logger.info("add meals with id = " + meals.getId());
        }
        return MEALS_PAGE;
    }

    private void buildMeals(HttpServletRequest request, MealsDTO mealsDTO) {
        Long product_id = Long.parseLong(request.getParameter(PARAM_FOOD));
        Long eatPeriod_id = Long.parseLong(request.getParameter(PARAM_EAT_PERIOD));

        EatPeriod eatPeriod = eatPeriodService.findEatPeriodById(eatPeriod_id).get();
        Product product = productService.findProductById(product_id).get();

        mealsDTO.setEatPeriod(eatPeriod);
        mealsDTO.setProduct(product);
        mealsDTO.setDate(new Timestamp(System.currentTimeMillis()));
    }

    private void checkCaloriesLimit(User user) {
        Integer calories = userService.countCalories(user);
        if (user.getClient() != null) {
            Client client = user.getClient();
            if (client.getCalories() < calories) {
                emailService.sendWarningLetter(user.getLogin());
            }
        }
    }
}
