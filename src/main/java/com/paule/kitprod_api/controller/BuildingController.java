package com.paule.kitprod_api.controller;

import com.paule.kitprod_api.model.Building;
import com.paule.kitprod_api.repository.BuildingRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BuildingController {

    public BuildingRepository buildingRepository;

//    @GetMapping(value = "/abuilding")
//    public Building getBuilding(Long id){
//        return buildingRepository.findById(id);
//    }

    @GetMapping(value = "/all-building")
    public List<Building> getAllBuilding(){
        return buildingRepository.findAll();
    }

    @PostMapping(value = "/create-building")
    public String createBuilding(@RequestBody Building building){
        Building insertedBuilding = buildingRepository.insert(building);
        return "Building created: "+insertedBuilding.getName();

    }

}
