package com.paule.kitprod_api.repository;

import com.paule.kitprod_api.model.Employee;
import com.paule.kitprod_api.model.Food;
import java.util.List;

public interface IFoodRepositoryCustom {
    public Food insert(String idExploitation, Food food);
    public List<Food> findAll(String idExploitation);
    public Food findById(String idExploitation, String idFood);
    public boolean delete(String idExploitation, String idFood);
    public Food update(String idExploitation, String idFood, Food food);
}
