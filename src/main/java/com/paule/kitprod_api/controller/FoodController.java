package com.paule.kitprod_api.controller;

import com.paule.kitprod_api.model.Food;
import com.paule.kitprod_api.repository.FoodRepositoryCustomImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
public class FoodController {


    @Autowired
    public FoodRepositoryCustomImpl foodRepositoryCustomImpl;

    @GetMapping(value = "/foods")
    public List<Food> getAllFood(@RequestParam String idExploitation){

        return foodRepositoryCustomImpl.findAll(idExploitation);
    }

    @PostMapping(value = "/foods")
    public Food createFood(@RequestParam String idExploitation, @RequestBody Food food){
        food.setId(UUID.randomUUID().toString());
        Food insertedFood = foodRepositoryCustomImpl.insert(idExploitation, food);

        return insertedFood;
    }
}
