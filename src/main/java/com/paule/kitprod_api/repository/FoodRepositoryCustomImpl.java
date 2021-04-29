package com.paule.kitprod_api.repository;

import com.paule.kitprod_api.model.Exploitation;
import com.paule.kitprod_api.model.Food;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class FoodRepositoryCustomImpl implements IFoodRepositoryCustom {

    @Autowired ExploitationRepository exploitationRepository;

    @Override
    public Food insert(long idExploitation, Food food) {
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
    public List<Food> findAll(long idExploitation) {
        Optional<Exploitation> exploitation = exploitationRepository.findById(idExploitation);
        if (exploitation.isPresent()){
            Exploitation existingExploitation = exploitation.get();

            return existingExploitation.getFoods();
        }
        return null;
    }
}
