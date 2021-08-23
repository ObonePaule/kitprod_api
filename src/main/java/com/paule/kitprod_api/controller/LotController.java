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
        Map<String, Double> foodCosts = new HashMap<>();
        double totalChargeCost = 0;
        Map<String, Double> chargeCosts = new HashMap<>();
        double totalEmployeeCosts = 0;
        double mortality;
        double totalNumberOfLosses = 0;

        Lot lot  = lotRepositoryCustomImpl.findById(idExploitation, idBuilding, idLot);
        List<LotSheet> lotSheets = lot.getLotSheets();
        List<DailyFood> dailyFoods = lotSheets.stream().map(LotSheet::getDailyFood).collect(Collectors.toList());
        for (DailyFood dailyFood: dailyFoods) {
            Food food = foodRepositoryCustomImpl.findById(idExploitation, dailyFood.getIdFood());
            double dailyFoodPrice = food.getPrice() * dailyFood.getValue();
            totalFoodCost += dailyFoodPrice;
            foodCosts.put(dailyFood.getIdFood(), foodCosts.getOrDefault(dailyFood.getIdFood(), (double) 0) + dailyFoodPrice);
        }

        // Le cout des charges pour un batiment donné(son nombre de m2)/ pour un lot, pour un animal: combien de metres carrés occupe une volaille dans ce batiment. Surface/nombre de volaille-perte(au fur et à mesure)
        List<Building> buildings = buildingRepositoryCustomImpl.findAll(idExploitation);
        double totalNumberOfSquareMeters = 0;
        double costBySquareMeter;
        for (Building building: buildings) {
            totalNumberOfSquareMeters += building.getSurface() * building.getNumberOfLots();
        }

        List<Charge> charges = chargeRepositoryCustomImpl.findAll(idExploitation);
        Building currentBuilding = buildingRepositoryCustomImpl.findById(idExploitation, idBuilding);
        for (Charge charge: charges){
            costBySquareMeter = charge.getValue()/totalNumberOfSquareMeters;
            double chargeByBuilding = costBySquareMeter * currentBuilding.getSurface();
            totalChargeCost += chargeByBuilding;
            chargeCosts.put(charge.getId(), chargeByBuilding);
        }

        List<Employee> employees = employeeRepositoryCustomImpl.findAll(idExploitation);
        for (Employee employee: employees){
            double costByEmployee = employee.getHourCost() * employee.getNumberOfHour() / totalNumberOfSquareMeters;
            totalEmployeeCosts += costByEmployee * currentBuilding.getSurface();
        }

        for (LotSheet lotSheet: lotSheets){
            totalNumberOfLosses += lotSheet.getLoss();
        }
        mortality = totalNumberOfLosses / lot.getNumber();

        return new Synthesis(foodCosts, totalFoodCost, chargeCosts, totalChargeCost, totalEmployeeCosts, mortality);
    }


}
