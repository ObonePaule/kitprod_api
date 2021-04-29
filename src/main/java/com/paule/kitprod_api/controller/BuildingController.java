package com.paule.kitprod_api.controller;

import com.paule.kitprod_api.model.Building;
import com.paule.kitprod_api.model.SequenceGeneratorService;
import org.springframework.web.bind.annotation.RequestParam;
import com.paule.kitprod_api.repository.BuildingRepositoryCustomImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BuildingController {

    @Autowired
    private SequenceGeneratorService sequenceGeneratorService;

    @Autowired
    public BuildingRepositoryCustomImpl buildingRepositoryCustomImpl;

    @GetMapping(value = "/buildings")
    public List<Building> getAllBuildings(@RequestParam long idExploitation){
        return buildingRepositoryCustomImpl.findAll(idExploitation);
    }

    @PostMapping(value = "/buildings")
    public String createBuilding(@RequestBody Building building, @RequestParam Long idExploitation){
        building.setId(sequenceGeneratorService.generateSequence(building.SEQUENCE_NAME));
        Building insertedBuilding = buildingRepositoryCustomImpl.insert(idExploitation, building);
        return "Building created: "+insertedBuilding.getName();

    }

}
