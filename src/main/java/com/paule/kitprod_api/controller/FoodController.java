package com.paule.kitprod_api.controller;

import com.paule.kitprod_api.repository.FoodRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FoodController {

    @Autowired
    public FoodRepository foodRepository;




}
