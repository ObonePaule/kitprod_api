package com.paule.kitprod_api.repository;

import com.paule.kitprod_api.model.Food;
import com.paule.kitprod_api.model.RawMaterial;
import com.paule.kitprod_api.repository.repoSave.FoodRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
public class RawMaterialRepositoryCustomImpl implements IRawMaterialRepositoryCustom{

    @Autowired
    public FoodRepository foodRepository;

    @Override
    public RawMaterial insert(long idFood, RawMaterial rawMaterial) {
        Optional<Food> food = foodRepository.findById(idFood);
        if (food.isPresent()){
            Food existingFood = food.get();
            existingFood.addRawMaterial(rawMaterial);
            foodRepository.save(existingFood);

            return rawMaterial;
        }

        return null;
    }

    @Override
    public List<RawMaterial> findAll(long idFood) {
        Optional<Food> food = foodRepository.findById(idFood);
        if (food.isPresent()) {
            Food existingFood = food.get();
            return existingFood.getRawMaterials();
        }

        return null;
    }
}

