package com.paule.kitprod_api.controller;

import com.paule.kitprod_api.model.RawMaterial;
import com.paule.kitprod_api.model.SequenceGeneratorService;
import com.paule.kitprod_api.repository.RawMaterialRepositoryCustomImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class RawMaterialController {

    @Autowired
    private SequenceGeneratorService sequenceGeneratorService;

    @Autowired
    public RawMaterialRepositoryCustomImpl rawMaterialRepositoryCustomImpl;

    @GetMapping(value = "/rawmaterials")
    public List<RawMaterial> getAllRawMaterials(@RequestParam long idExploitation, @RequestParam long idFood ){
        return rawMaterialRepositoryCustomImpl.findAll(idExploitation, idFood);
    }

    @PostMapping(value = "/rawmaterials")
    public String createRawMaterial( @RequestParam long idExploitation, @RequestParam long idFood, @RequestBody RawMaterial rawMaterial){
        rawMaterial.setId(sequenceGeneratorService.generateSequence(rawMaterial.SEQUENCE_NAME));
        RawMaterial insertedRawMaterial = rawMaterialRepositoryCustomImpl.insert(idExploitation, idFood, rawMaterial);

        return "RawMaterial created: "+rawMaterial.getName();
    }


}
