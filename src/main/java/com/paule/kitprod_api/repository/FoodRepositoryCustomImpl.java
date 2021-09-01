package com.paule.kitprod_api.repository;

import com.paule.kitprod_api.model.Employee;
import com.paule.kitprod_api.model.Exploitation;
import com.paule.kitprod_api.model.Food;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Collectors;

@Repository
public class FoodRepositoryCustomImpl implements IFoodRepositoryCustom {

    @Autowired ExploitationRepository exploitationRepository;

    @Override
    public Food insert(String idExploitation, Food food) {
        Optional<Exploitation> exploitation = exploitationRepository.findById(idExploitation);

        if (exploitation.isPresent()){
            Exploitation existingExploitation = exploitation.get();
            existingExploitation.addFood(food);
            exploitationRepository.save(existingExploitation);

            return food;
        }
        return null;
    }

    @Override
    public List<Food> findAll(String idExploitation) {
        Optional<Exploitation> exploitation = exploitationRepository.findById(idExploitation);

        if (exploitation.isPresent()){
            Exploitation existingExploitation = exploitation.get();

            return existingExploitation.getFoods();
        }
        return null;
    }

    @Override
    public Food findById(String idExploitation, String idFood) {
        List<Food> foods = this.findAll(idExploitation);
        Predicate<Food> byId = food -> food.getId().equals(idFood);
        List<Food> foodById = foods.stream().filter(byId).collect(Collectors.toList());

        if (!foodById.isEmpty()){

            return foodById.get(0);
        }

        return null;
    }

    @Override
    public boolean delete(String idExploitation, String idFood) {
        boolean wasRemoved = false;
        Optional<Exploitation> exploitation = exploitationRepository.findById(idExploitation);

        if (exploitation.isPresent()) {
            Exploitation existingExploitation = exploitation.get();
            wasRemoved = existingExploitation.removeFood(idFood);
            exploitationRepository.save(existingExploitation);

            return wasRemoved;
        }

        return wasRemoved;
    }

    @Override
    public Food update(String idExploitation, String idFood, Food updatedFood) {
        Optional<Exploitation> exploitation = exploitationRepository.findById(idExploitation);

        if (exploitation.isPresent()) {
            Exploitation existingExploitation = exploitation.get();
            List<Food> updatedFoods = existingExploitation.getFoods().stream().peek(food -> {
                if (food.getId().equals(idFood)) {
                    food.setName(updatedFood.getName());
                    food.setFafPrestation(updatedFood.getFafPrestation());
                    food.setRawMaterials(updatedFood.getRawMaterials());

                    updatedFood.setId(food.getId());
                }
            }).collect(Collectors.toList());

            existingExploitation.setFoods(updatedFoods);
            exploitationRepository.save(existingExploitation);

            return updatedFood;
        }
        return null;
    }

}
