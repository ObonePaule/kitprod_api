package com.paule.kitprod_api.controller;

import com.paule.kitprod_api.model.Lot;
import com.paule.kitprod_api.model.SequenceGeneratorService;
import com.paule.kitprod_api.repository.LotRepositoryCustomImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class LotController {

    @Autowired
    private SequenceGeneratorService sequenceGeneratorService;

    @Autowired
    public LotRepositoryCustomImpl lotRepositoryCustomImpl;

    @GetMapping(value = "/lots")
    public List<Lot> getAllLots(@RequestParam long idExploitation, @RequestParam long idBuilding ){
        return lotRepositoryCustomImpl.findAll(idExploitation, idBuilding);
    }

    @PostMapping(value = "/lots")
    public String createLot( @RequestParam long idExploitation, @RequestParam long idBuilding, @RequestBody Lot lot){
        lot.setId(sequenceGeneratorService.generateSequence(lot.SEQUENCE_NAME));
        Lot insertedLot = lotRepositoryCustomImpl.insert(idExploitation, idBuilding, lot);

        return "Lot created: "+lot.getName();
    }


}
