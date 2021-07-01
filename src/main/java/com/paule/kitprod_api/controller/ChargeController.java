package com.paule.kitprod_api.controller;

import com.paule.kitprod_api.model.Charge;
import com.paule.kitprod_api.model.SequenceGeneratorService;
import com.paule.kitprod_api.repository.ChargeRepositoryCustomImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
public class ChargeController {

    @Autowired
    private SequenceGeneratorService sequenceGeneratorService;

    @Autowired
    public ChargeRepositoryCustomImpl chargeRepositoryCustomImpl;

    @GetMapping(value = "/charges")
    public List<Charge> getAllCharges(@RequestParam String idExploitation){

        return chargeRepositoryCustomImpl.findAll(idExploitation);
    }

    @PostMapping(value = "/charges")
    public void createCharge(@RequestParam String idExploitation, @RequestBody ArrayList<Charge> charges){
        for (int i=0 ; i<charges.size(); i++) {
            Charge charge = charges.get(i);
            charge.setId(UUID.randomUUID().toString());
            Charge insertedCharge = chargeRepositoryCustomImpl.insert(idExploitation, charge);
        }
    }
}
