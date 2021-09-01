package com.paule.kitprod_api.repository;

import com.paule.kitprod_api.model.Building;
import com.paule.kitprod_api.model.Exploitation;
import com.paule.kitprod_api.model.Lot;
import com.paule.kitprod_api.model.Synthesis;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Collectors;

@Repository
public class LotRepositoryCustomImpl implements ILotRepositoryCustom {

    @Autowired
    public ExploitationRepository exploitationRepository;
    @Autowired
    public BuildingRepositoryCustomImpl buildingRepositoryCustomImpl;

    @Override
    public Lot insert(String idExploitation, String idBuilding, Lot lot) {
        Optional<Exploitation> exploitation = exploitationRepository.findById(idExploitation);

        if (exploitation.isPresent()) {
            Exploitation existingExploitation = exploitation.get();
            existingExploitation.addLot(idBuilding, lot);
            exploitationRepository.save(existingExploitation);

            return lot;
        }
        return null;
    }

    @Override
    public List<Lot> findAll(String idExploitation, String idBuilding) {
        Building existingBuilding = buildingRepositoryCustomImpl.findById(idExploitation, idBuilding);
        if (existingBuilding != null) {

            return existingBuilding.getLots();
        }
        return null;
    }

    @Override
    public Lot findById(String idExploitation, String idBuilding, String idLot) {
        List<Lot> lots = this.findAll(idExploitation, idBuilding);
        Predicate<Lot> byId = lot -> lot.getId().equals(idLot);
        List<Lot> lotById = lots.stream().filter(byId).collect(Collectors.toList());

        if (!lotById.isEmpty()) {

            return lotById.get(0);
        }
        return null;
    }

    public void archive(String idExploitation, String idBuilding, String idLot) {
        Optional<Exploitation> exploitation = exploitationRepository.findById(idExploitation);
        if (exploitation.isPresent()) {
            Exploitation existingExploitation = exploitation.get();
            List<Building> updatedBuildings = existingExploitation.getBuildings().stream().peek(building -> {
                if (building.getId().equals(idBuilding)) {
                    List<Lot> updatedLots = building.getLots().stream().peek(lot -> {
                        if (lot.getId().equals(idLot)) {
                            lot.setArchived(true);
                        }
                    }).collect(Collectors.toList());

                    building.setLots(updatedLots);
                }
            }).collect(Collectors.toList());

            existingExploitation.setBuildings(updatedBuildings);
            exploitationRepository.save(existingExploitation);
        }
    }

    public void unarchive(String idExploitation, String idBuilding, String idLot) {
        Optional<Exploitation> exploitation = exploitationRepository.findById(idExploitation);
        if (exploitation.isPresent()) {
            Exploitation existingExploitation = exploitation.get();
            List<Building> updatedBuildings = existingExploitation.getBuildings().stream().peek(building -> {
                if (building.getId().equals(idBuilding)) {
                    List<Lot> updatedLots = building.getLots().stream().peek(lot -> {
                        if (lot.getId().equals(idLot)) {
                            lot.setArchived(false);
                        }
                    }).collect(Collectors.toList());

                    building.setLots(updatedLots);
                }
            }).collect(Collectors.toList());

            existingExploitation.setBuildings(updatedBuildings);
            exploitationRepository.save(existingExploitation);
        }
    }

    public Lot update(String idExploitation, String idBuilding, String idLot, Lot updatedlot) {
        Optional<Exploitation> exploitation = exploitationRepository.findById(idExploitation);
        if (exploitation.isPresent()) {
            Exploitation existingExploitation = exploitation.get();
            List<Building> updatedBuildings = existingExploitation.getBuildings().stream().peek(building -> {
                if (building.getId().equals(idBuilding)) {
                    List<Lot> updatedLots = building.getLots().stream().peek(lot -> {
                        if (lot.getId().equals(idLot)) {
                            lot.setName(updatedlot.getName());
                            lot.setSpecies(updatedlot.getSpecies());
                            lot.setMepAge(updatedlot.getMepAge());
                            lot.setCostByAnimal(updatedlot.getCostByAnimal());
                            lot.setNumberOfMales(updatedlot.getNumberOfMales());
                            lot.setNumberOfFemales(updatedlot.getNumberOfFemales());
                            lot.setNumberOfAllcomers(updatedlot.getNumberOfAllcomers());
                            lot.setCostOfLitter(updatedlot.getCostOfLitter());
                            lot.setFixedTasks(updatedlot.getFixedTasks());
                            lot.setLotSheets(updatedlot.getLotSheets());

                            updatedlot.setId(idLot);
                        }
                    }).collect(Collectors.toList());

                    building.setLots(updatedLots);
                }
            }).collect(Collectors.toList());

            existingExploitation.setBuildings(updatedBuildings);
            exploitationRepository.save(existingExploitation);
        }
        return updatedlot;
    }

    public void saveSynthesis(String idExploitation, String idBuilding, String idLot, Synthesis synthesis) {
        Optional<Exploitation> exploitation = exploitationRepository.findById(idExploitation);
        if (exploitation.isPresent()) {
            Exploitation existingExploitation = exploitation.get();
            List<Building> updatedBuildings = existingExploitation.getBuildings().stream().peek(building -> {
                if (building.getId().equals(idBuilding)) {
                    List<Lot> updatedLots = building.getLots().stream().peek(lot -> {
                        if (lot.getId().equals(idLot)) {
                            lot.setSynthesis(synthesis);
                        }
                    }).collect(Collectors.toList());

                    building.setLots(updatedLots);
                }
            }).collect(Collectors.toList());

            existingExploitation.setBuildings(updatedBuildings);
            exploitationRepository.save(existingExploitation);
        }
    }


}
