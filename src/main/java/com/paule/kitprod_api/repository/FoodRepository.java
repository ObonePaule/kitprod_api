package com.paule.kitprod_api.repository;

import com.paule.kitprod_api.model.Food;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FoodRepository extends MongoRepository<Food, Long> {
}
