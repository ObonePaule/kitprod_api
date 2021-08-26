package com.paule.kitprod_api.controller;

import com.paule.kitprod_api.model.*;
import com.paule.kitprod_api.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;
import java.util.stream.Collectors;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
public class LotController {

    @Autowired
    private SequenceGeneratorService sequenceGeneratorService;

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
    public List<Lot> getAllLots(@RequestParam String idExploitation, @RequestParam String idBuilding ){
        return lotRepositoryCustomImpl.findAll(idExploitation, idBuilding);
    }

    @PostMapping(value = "/lots")
    public Lot createLot( @RequestParam String idExploitation, @RequestParam String idBuilding, @RequestBody Lot lot){
        lot.setId(UUID.randomUUID().toString());
        Lot insertedLot = lotRepositoryCustomImpl.insert(idExploitation, idBuilding, lot);

        return insertedLot;
    }

//    @PutMapping(value = "/update/{movieId}")
//    public Movie updateMovie(@PathVariable String movieId, @RequestBody Movie movie) {
//        logger.info("Updating movie with ID: {}", movieId);
//        return movieRepository.save(movie);
//    }

//    @DeleteMapping(value = "/delete/{movieId}")
//    public void deleteMovie(@PathVariable String movieId) {
//        logger.info("Deleting movie with ID: {}", movieId);
//        movieRepository.deleteById(movieId);
//    }



    @GetMapping(value= "/synthesis")
    public Synthesis getSynthesis (@RequestParam String idExploitation, @RequestParam String idBuilding, @RequestParam String idLot) {
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


        // Recuperation de toutes les fiches de lot
        Lot lot  = lotRepositoryCustomImpl.findById(idExploitation, idBuilding, idLot);
        List<LotSheet> lotSheets = lot.getLotSheets();

        //Nombre d'animaux abattus et poids moyen
        int numberOfAnimalsSold = 0;
        List<Removal> removals = lotSheets.stream().map(LotSheet::getRemoval).collect(Collectors.toList());
        for (Removal removal: removals) {
            if (removal.getNumberOfAllComers() == 0){
                numberOfAnimalsSold += removal.getNumberOfFemales() + removal.getNumberOfMales();
            }
            numberOfAnimalsSold += removal.getNumberOfAllComers();
        }
        System.out.println(numberOfAnimalsSold);


        // Synthese aliment
        List<DailyFood> dailyFoods = lotSheets.stream().map(LotSheet::getDailyFood).collect(Collectors.toList());
        for (DailyFood dailyFood: dailyFoods) {

            totalFoodQuantity += dailyFood.getValue() / numberOfAnimalsSold;

            String foodType = dailyFood.getIdFood();
            quantityByFood.put(foodType, quantityByFood.getOrDefault(foodType, (double) 0) + (dailyFood.getValue()/numberOfAnimalsSold));
        }
        for (Map.Entry quantityFoodMap : quantityByFood.entrySet()) {
            Food food = foodRepositoryCustomImpl.findById(idExploitation, (String) quantityFoodMap.getKey());
            System.out.println(food);
            double dailyFoodPrice = food.getPrice() * (double)quantityFoodMap.getValue();
            totalFoodCost += dailyFoodPrice;
            costByFood.put( (String) quantityFoodMap.getKey(), costByFood.getOrDefault(quantityFoodMap.getKey(), (double) 0) + dailyFoodPrice);
        }

        // Le nombre de metres carrés sur une année
        List<Building> buildings = buildingRepositoryCustomImpl.findAll(idExploitation);
        double totalNumberOfSquareMeters = 0;
        for (Building building: buildings) {
            totalNumberOfSquareMeters += building.getSurface() * building.getNumberOfLots();
        }


        // Synthese des charges par animal
        Building currentBuilding = buildingRepositoryCustomImpl.findById(idExploitation, idBuilding);
        List<Charge> charges = chargeRepositoryCustomImpl.findAll(idExploitation);
        for (Charge charge: charges){
            double chargeCostBySquareMeter = charge.getValue()/totalNumberOfSquareMeters;
            double chargeByAnimal = chargeCostBySquareMeter * currentBuilding.getSurface() / numberOfAnimalsSold;
            totalChargeCost += chargeByAnimal;
            costByCharge.put(charge.getId(), chargeByAnimal);
        }

        // Synthèse de la main d'oeuvre par animal

        List<Employee> employees = employeeRepositoryCustomImpl.findAll(idExploitation);
        for (Employee employee: employees){
            double costByEmployeeBySquareMeters = employee.getHourCost() * employee.getNumberOfHour() / totalNumberOfSquareMeters;
            totalEmployeesCost += costByEmployeeBySquareMeters * currentBuilding.getSurface() / numberOfAnimalsSold;
        }

        //Calcul de la Mortalité
        double totalNumberOfLosses = 0;
        double totalNumberOfLotAnimals = 0;
        if (lot.getNumberOfAllcomers() == 0){
            totalNumberOfLotAnimals = lot.getNumberOfFemales() + lot.getNumberOfMales();
        }
        totalNumberOfLotAnimals = lot.getNumberOfAllcomers();

        for (LotSheet lotSheet: lotSheets){
            totalNumberOfLosses += lotSheet.getLoss();
        }
        lossPercent = (totalNumberOfLosses / totalNumberOfLotAnimals) * 100;

        //Calcul du poids moyen
        double averageWeightByRemoval = 0;
        int numberOfRemovals = 0;
        for(Removal removal: removals){
            if(removal.isDone() == true){
                numberOfRemovals += 1;
            }
            if (removal.getNumberOfAllComers() != 0){
                averageWeightByRemoval = removal.getWeightByAllComers();
            }
            else if (removal.getNumberOfFemales() == 0){
                averageWeightByRemoval = removal.getWeightByMale();
            }
            else if (removal.getNumberOfMales() == 0){
                averageWeightByRemoval = removal.getWeightByFemale();
            }
            else{
                averageWeightByRemoval = (removal.getWeightByFemale() + removal.getNumberOfMales())/2;
            }
            averageWeight += averageWeightByRemoval / numberOfRemovals;
        }

        //Calcul du gain moyen quotidien
        averageDailyGain = averageWeight / lotSheets.size();

        //Calcul de l'indice de consommation
        consumptionIndex = totalFoodQuantity / averageWeight;

        return new Synthesis(costByFood, totalFoodCost, quantityByFood, totalFoodQuantity, costByCharge, totalChargeCost, totalEmployeesCost, lossPercent, averageWeight, averageDailyGain, consumptionIndex);
    }


}
