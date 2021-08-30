package com.paule.kitprod_api.controller;

import com.paule.kitprod_api.model.Building;
import com.paule.kitprod_api.repository.BuildingRepositoryCustomImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
public class BuildingController {

    @Autowired
    public BuildingRepositoryCustomImpl buildingRepositoryCustomImpl;

    @GetMapping(value = "/buildings")
    public List<Building> getAllBuildings(@RequestParam String idExploitation) {

        return buildingRepositoryCustomImpl.findAll(idExploitation);
    }

    @PostMapping(value = "/buildings")
    public Building createBuilding(@RequestParam String idExploitation, @RequestBody Building building) {
        building.setId(UUID.randomUUID().toString());
        Building insertedBuilding = buildingRepositoryCustomImpl.insert(idExploitation, building);

        return insertedBuilding;
    }
}
