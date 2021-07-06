package com.paule.kitprod_api.repository;

import com.paule.kitprod_api.model.Building;
import com.paule.kitprod_api.model.Exploitation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Collectors;

@Repository
public class BuildingRepositoryCustomImpl implements IBuildingRepositoryCustom {

    @Autowired
    ExploitationRepository exploitationRepository;

    @Override
    public Building insert(String idExploitation, Building building) {
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
    public List<Building> findAll(String idExploitation) {
        Optional<Exploitation> exploitation = exploitationRepository.findById(idExploitation);

        if (exploitation.isPresent()) {

            Exploitation existingExploitation = exploitation.get();

            return existingExploitation.getBuildings();
        }
        return null;
    }

    @Override
    public Building findById(String idExploitation, String idBuilding) {
        List<Building> buildings = this.findAll(idExploitation);
        Predicate<Building> byId = building -> building.getId().equals(idBuilding);
        List<Building> buildingById = buildings.stream().filter(byId).collect(Collectors.toList());

        if (!buildingById.isEmpty()){

            return buildingById.get(0);
        }
        return null;
    }
}
