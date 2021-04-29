package com.paule.kitprod_api.repository;

import com.paule.kitprod_api.model.Building;
import com.paule.kitprod_api.model.Exploitation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class BuildingRepositoryCustomImpl implements IBuildingRepositoryCustom {

    @Autowired
    ExploitationRepository exploitationRepository;

    @Override
    public Building insert(long idExploitation, Building building) {
        Optional<Exploitation> exploitation = exploitationRepository.findById(idExploitation);

        if (exploitation.isPresent()) {
            Exploitation existingExploitation = exploitation.get();

            existingExploitation.addBuilding(building);
            exploitationRepository.save(existingExploitation);

            return building;
        }
        return null;
    }

    @Override
    public List<Building> findAll(long idExploitation) {
        Optional<Exploitation> exploitation = exploitationRepository.findById(idExploitation);
        if (exploitation.isPresent()) {
            Exploitation existingExploitation = exploitation.get();

            return existingExploitation.getBuildings();
        }
        return null;
    }
}
