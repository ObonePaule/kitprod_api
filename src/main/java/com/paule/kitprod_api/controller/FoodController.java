package com.paule.kitprod_api.controller;

import com.paule.kitprod_api.model.Food;
import com.paule.kitprod_api.model.SequenceGeneratorService;
import com.paule.kitprod_api.repository.FoodRepositoryCustomImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class FoodController {

    @Autowired
    private SequenceGeneratorService sequenceGeneratorService;

    @Autowired
    public FoodRepositoryCustomImpl foodRepositoryCustomImpl;

    @GetMapping(value = "/foods")
    public List<Food> getAllFood(@RequestParam long idExploitation){
        return foodRepositoryCustomImpl.findAll(idExploitation);
    }

    @PostMapping(value = "/foods")
    public String createFood(@RequestParam long idExploitation, @RequestBody Food food){
        food.setId(sequenceGeneratorService.generateSequence(food.SEQUENCE_NAME));
        Food insertedFood = foodRepositoryCustomImpl.insert(idExploitation, food);
        return "Food inserted"+insertedFood.getName();
    }
}
