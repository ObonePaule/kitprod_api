package com.paule.kitprod_api.repository;

import com.paule.kitprod_api.model.Building;
import com.paule.kitprod_api.model.Exploitation;
import com.paule.kitprod_api.model.Food;
import com.paule.kitprod_api.model.Lot;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Collectors;

@Repository
public class LotRepositoryCustomImpl implements ILotRepositoryCustom{

    @Autowired private ExploitationRepository exploitationRepository;
    @Autowired public BuildingRepositoryCustomImpl buildingRepositoryCustomImpl;

    @Override
    public Lot insert(long idExploitation, long idBuilding, Lot lot) {
        Optional<Exploitation> exploitation = exploitationRepository.findById(idExploitation);
        if (exploitation.isPresent()){
            Exploitation existingExploitation = exploitation.get();
            existingExploitation.addLot(idBuilding, lot);
            exploitationRepository.save(existingExploitation);

            return lot ;
        }

        return null;
    }

    @Override
    public List<Lot> findAll(long idExploitation, long idBuilding) {
        Building existingBuilding = buildingRepositoryCustomImpl.findById(idExploitation, idBuilding);
        if (existingBuilding != null){
            return existingBuilding.getLots();
        }

        return null;
    }

    @Override
    public Lot findById(long idExploitation, long idBuilding, long idLot) {
        List<Lot> lots = this.findAll(idExploitation, idBuilding);
        Predicate<Lot> byId = lot-> lot.getId() == idLot;

        List<Lot> lotById = lots.stream().filter(byId).collect(Collectors.toList());
        if (!lotById.isEmpty()){
            return lotById.get(0);
        }
        return null;
    }
}
