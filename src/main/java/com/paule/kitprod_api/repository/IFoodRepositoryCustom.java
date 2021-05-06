package com.paule.kitprod_api.repository;

import com.paule.kitprod_api.model.Food;
import java.util.List;

public interface IFoodRepositoryCustom {
    public Food insert(long idExploitation, Food food);
    public List<Food> findAll(long idExploitation);
    public Food findById(long idExploitation, long idFood);
}
