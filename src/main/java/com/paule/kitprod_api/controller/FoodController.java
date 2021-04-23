package com.paule.kitprod_api.controller;

import com.paule.kitprod_api.model.Food;
import com.paule.kitprod_api.repository.FoodRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class FoodController {

    @Autowired
    public FoodRepository foodRepository;

    @GetMapping(value = "/all-food")
    public List<Food> getAllFood(){
        return foodRepository.findAll();
    }

    @PostMapping(value = "/create-food")
    public String createdFood(@RequestBody Food food){
        Food insertedFood = foodRepository.insert(food);
        return "Food inserted"+insertedFood.getName();
    }
}
