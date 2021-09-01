package com.paule.kitprod_api.controller;

import com.paule.kitprod_api.model.*;
import com.paule.kitprod_api.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;
import java.util.stream.Collectors;

@CrossOrigin(origins = "*", maxAge = 3600, methods = { RequestMethod.PUT, RequestMethod.POST, RequestMethod.DELETE,
        RequestMethod.GET })
@RestController
public class LotController {

    @Autowired
    public ExploitationRepository exploitationRepository;

    @Autowired
    public LotRepositoryCustomImpl lotRepositoryCustomImpl;

    @Autowired
    public FoodRepositoryCustomImpl foodRepositoryCustomImpl;

    @Autowired
    public BuildingRepositoryCustomImpl buildingRepositoryCustomImpl;

    @Autowired
    public ChargeRepositoryCustomImpl chargeRepositoryCustomImpl;

    @Autowired
    public EmployeeRepositoryCustomImpl employeeRepositoryCustomImpl;

    @GetMapping(value = "/lots")
    public List<Lot> getLots(@RequestParam String idExploitation, @RequestParam String idBuilding) {
        return lotRepositoryCustomImpl.findAll(idExploitation, idBuilding);
    }

    @PostMapping(value = "/lots")
    public Lot createLot(@RequestParam String idExploitation, @RequestParam String idBuilding, @RequestBody Lot lot) {
        lot.setId(UUID.randomUUID().toString());
        Lot insertedLot = lotRepositoryCustomImpl.insert(idExploitation, idBuilding, lot);

        return insertedLot;
    }

    @PutMapping(value = "/lots/archive")
    public boolean archiveLot(@RequestParam String idExploitation, @RequestParam String idBuilding,
            @RequestParam String idLot) {
        lotRepositoryCustomImpl.archive(idExploitation, idBuilding, idLot);

        return true;
    }

    @PutMapping(value = "/lots/unarchive")
    public boolean unarchiveLot(@RequestParam String idExploitation, @RequestParam String idBuilding,
            @RequestParam String idLot) {
        lotRepositoryCustomImpl.unarchive(idExploitation, idBuilding, idLot);

        return true;
    }

    @PutMapping(value = "/lots")
    public Lot updateLot(@RequestParam String idExploitation, @RequestParam String idBuilding,
            @RequestParam String idLot, @RequestBody Lot lot) {
        return lotRepositoryCustomImpl.update(idExploitation, idBuilding, idLot, lot);
    }
    //
    // @DeleteMapping(value = "/lots")
    // public void deleteLot(@RequestParam String idExploitation, @RequestParam
    // String idBuilding, @RequestParam String idLot) {
    //
    //
    // }
    // }

    @GetMapping(value = "/synthesis")
    public Synthesis getSynthesis(@RequestParam String idExploitation, @RequestParam String idBuilding,
            @RequestParam String idLot) {
        double totalFoodCost = 0;
        Map<String, Double> costByFood = new HashMap<>();

        double totalFoodQuantity = 0;
        Map<String, Double> quantityByFood = new HashMap<>();

        double totalChargeCost = 0;
        Map<String, Double> costByCharge = new HashMap<>();

        double totalEmployeesCost = 0;

        double lossPercent = 0;

        double averageWeight = 0;

        double averageDailyGain = 0;

        double consumptionIndex = 0;

        Map<String, Double> variousCharges = new HashMap<>();

        double totalVariousCharges = 0;

        // Recuperation de toutes les fiches de lot
        Lot currentLot = lotRepositoryCustomImpl.findById(idExploitation, idBuilding, idLot);
        List<LotSheet> lotSheets = currentLot.getLotSheets();

        // Nombre d'animaux abattus et poids moyen
        int numberOfAnimalsSold = 0;
        List<Removal> removals = lotSheets.stream().map(LotSheet::getRemoval).collect(Collectors.toList());
        for (Removal removal : removals) {
            if (removal.getNumberOfAllComers() == 0) {
                numberOfAnimalsSold += removal.getNumberOfFemales() + removal.getNumberOfMales();
            }
            numberOfAnimalsSold += removal.getNumberOfAllComers();
        }

        // Synthese aliment
        List<DailyFood> dailyFoods = lotSheets.stream().map(LotSheet::getDailyFood).collect(Collectors.toList());
        for (DailyFood dailyFood : dailyFoods) {

            totalFoodQuantity += dailyFood.getValue() / numberOfAnimalsSold;

            String foodType = dailyFood.getIdFood();
            quantityByFood.put(foodType,
                    quantityByFood.getOrDefault(foodType, (double) 0) + (dailyFood.getValue() / numberOfAnimalsSold));
        }
        for (Map.Entry<String, Double> quantityFoodMap : quantityByFood.entrySet()) {
            Food food = foodRepositoryCustomImpl.findById(idExploitation, (String) quantityFoodMap.getKey());
            double dailyFoodPrice = food.getPrice() * (double) quantityFoodMap.getValue();
            totalFoodCost += dailyFoodPrice;
            costByFood.put((String) quantityFoodMap.getKey(),
                    costByFood.getOrDefault(quantityFoodMap.getKey(), (double) 0) + dailyFoodPrice);
        }

        // Le nombre de metres carrés sur une année
        List<Building> buildings = buildingRepositoryCustomImpl.findAll(idExploitation);
        double totalNumberOfSquareMeters = 0;
        for (Building building : buildings) {
            totalNumberOfSquareMeters += building.getSurface() * building.getNumberOfLots();
        }

        // Synthese des charges par animal
        Building currentBuilding = buildingRepositoryCustomImpl.findById(idExploitation, idBuilding);
        List<Charge> charges = chargeRepositoryCustomImpl.findAll(idExploitation);
        for (Charge charge : charges) {
            double chargeCostBySquareMeter = charge.getValue() / totalNumberOfSquareMeters;
            double chargeByAnimal = chargeCostBySquareMeter * currentBuilding.getSurface() / numberOfAnimalsSold;
            totalChargeCost += chargeByAnimal;
            costByCharge.put(charge.getId(), chargeByAnimal);
        }

        // Synthèse de la main d'oeuvre par animal

        List<Employee> employees = employeeRepositoryCustomImpl.findAll(idExploitation);
        for (Employee employee : employees) {
            double costByEmployeeBySquareMeters = employee.getHourCost() * employee.getNumberOfHour()
                    / totalNumberOfSquareMeters;
            totalEmployeesCost += costByEmployeeBySquareMeters * currentBuilding.getSurface() / numberOfAnimalsSold;
        }

        // Calcul de la Mortalité
        double totalNumberOfLosses = 0;
        double totalNumberOfLotAnimals;
        if (currentLot.getNumberOfAllcomers() == 0) {
            totalNumberOfLotAnimals = currentLot.getNumberOfFemales() + currentLot.getNumberOfMales();
        } else {
            totalNumberOfLotAnimals = currentLot.getNumberOfAllcomers();
        }

        for (LotSheet lotSheet : lotSheets) {
            totalNumberOfLosses += lotSheet.getLoss();
        }
        lossPercent = (totalNumberOfLosses / totalNumberOfLotAnimals) * 100;

        // Calcul du poids moyen
        double averageWeightByRemoval = 0;
        int numberOfRemovals = 0;
        double tempAverageWeight = 0;
        for (Removal removal : removals) {
            if (removal.isDone() == true) {
                numberOfRemovals += 1;
            }
            if (removal.getNumberOfAllComers() != 0) {
                averageWeightByRemoval = removal.getWeightByAllComers();
            } else if (removal.getNumberOfFemales() == 0 && removal.getNumberOfMales() != 0) {
                averageWeightByRemoval = removal.getWeightByMale();
            } else if (removal.getNumberOfMales() == 0 && removal.getNumberOfFemales() != 0) {
                averageWeightByRemoval = removal.getWeightByFemale();
            } else {
                averageWeightByRemoval = (removal.getWeightByFemale() + removal.getWeightByMale()) / 2;
            }
            tempAverageWeight += averageWeightByRemoval;
        }
        averageWeight = tempAverageWeight / numberOfRemovals;

        // Calcul du gain moyen quotidien
        averageDailyGain = averageWeight / lotSheets.size();

        // Calcul de l'indice de consommation
        consumptionIndex = totalFoodQuantity / averageWeight;

        double costByAnimal = (currentLot.getCostByAnimal() * totalNumberOfLotAnimals) / numberOfAnimalsSold;
        double litterCostByAnimal = currentLot.getCostOfLitter() / numberOfAnimalsSold;
        double vaccinCostByAnimal = 0;
        double veterinaryCostByAnimal = 0;

        List<SpecialEvent> specialEvents = lotSheets.stream().map(LotSheet::getSpecialEvent)
                .collect(Collectors.toList());
        for (SpecialEvent specialEvent : specialEvents) {
            vaccinCostByAnimal += specialEvent.getVaccin() / numberOfAnimalsSold;
            veterinaryCostByAnimal += specialEvent.getFraisVeterinaires() / numberOfAnimalsSold;
        }

        totalVariousCharges = costByAnimal + litterCostByAnimal + vaccinCostByAnimal + veterinaryCostByAnimal;

        variousCharges.put("costByAnimal", costByAnimal);
        variousCharges.put("litterCostByAnimal", litterCostByAnimal);
        variousCharges.put("vaccinCostByAnimal", vaccinCostByAnimal);
        variousCharges.put("veterinaryCostByAnimal", veterinaryCostByAnimal);

        Synthesis synthesis = new Synthesis(costByFood, totalFoodCost, quantityByFood, totalFoodQuantity, costByCharge,
                totalChargeCost, totalEmployeesCost, lossPercent, averageWeight, averageDailyGain, consumptionIndex,
                variousCharges, totalVariousCharges);
        lotRepositoryCustomImpl.saveSynthesis(idExploitation, idBuilding,idLot, synthesis);

        return synthesis;
    }

}
