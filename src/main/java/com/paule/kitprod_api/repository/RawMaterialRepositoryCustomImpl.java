package com.paule.kitprod_api.repository;

import com.paule.kitprod_api.model.Exploitation;
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
    public ExploitationRepository exploitationRepository;

    @Autowired
    public FoodRepositoryCustomImpl foodRepositoryCustomImpl;

    @Override
    public RawMaterial insert(long idExploitation, long idFood, RawMaterial rawMaterial) {
        Optional<Exploitation> exploitation = exploitationRepository.findById(idExploitation);
        if (exploitation.isPresent()){
            Exploitation existingExploitation = exploitation.get();
            existingExploitation.addRawMaterial(idFood, rawMaterial);
            exploitationRepository.save(existingExploitation);

            return rawMaterial;
        }

        return null;
    }

    @Override
    public List<RawMaterial> findAll(long idExploitation, long idFood) {
        Food existingFood = foodRepositoryCustomImpl.findById(idExploitation, idFood);
        if (existingFood != null){
            return existingFood.getRawMaterials();
        }

        return null;
    }
}

