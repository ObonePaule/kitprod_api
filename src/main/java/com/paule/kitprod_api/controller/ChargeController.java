package com.paule.kitprod_api.controller;

import com.paule.kitprod_api.model.Charge;
import com.paule.kitprod_api.model.SequenceGeneratorService;
import com.paule.kitprod_api.repository.ChargeRepositoryCustomImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ChargeController {

    @Autowired
    private SequenceGeneratorService sequenceGeneratorService;

    @Autowired
    public ChargeRepositoryCustomImpl chargeRepositoryCustomImpl;

    @GetMapping(value = "/charges")
    public List<Charge> getAllCharges(@RequestParam Long idExploitation){
        return chargeRepositoryCustomImpl.findAll(idExploitation);
    }

    @PostMapping(value = "/charges")
    public String createCharge(@RequestParam Long idExploitation, @RequestBody Charge charge){
        charge.setId(sequenceGeneratorService.generateSequence(Charge.SEQUENCE_NAME));
        Charge insertedCharge = chargeRepositoryCustomImpl.insert(idExploitation, charge);

        return "Inserted charge with type: " + insertedCharge.getChargeType().label;
    }
}
