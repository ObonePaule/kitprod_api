package com.paule.kitprod_api.controller;

import com.paule.kitprod_api.model.Lot;
import com.paule.kitprod_api.model.SequenceGeneratorService;
import com.paule.kitprod_api.repository.LotRepositoryCustomImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
public class LotController {

    @Autowired
    private SequenceGeneratorService sequenceGeneratorService;

    @Autowired
    public LotRepositoryCustomImpl lotRepositoryCustomImpl;

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


}
