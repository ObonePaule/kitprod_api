package com.paule.kitprod_api.controller;

import com.paule.kitprod_api.model.RawMaterial;
import com.paule.kitprod_api.repository.RawMaterialRepositoryCustomImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
public class RawMaterialController {

    @Autowired
    public RawMaterialRepositoryCustomImpl rawMaterialRepositoryCustomImpl;

    @GetMapping(value = "/rawmaterials")
    public List<RawMaterial> getAllRawMaterials(@RequestParam String idExploitation, @RequestParam String idFood) {

        return rawMaterialRepositoryCustomImpl.findAll(idExploitation, idFood);
    }

    @PostMapping(value = "/rawmaterials")
    public RawMaterial createRawMaterial(@RequestParam String idExploitation, @RequestParam String idFood,
            @RequestBody RawMaterial rawMaterial) {
        rawMaterial.setId(UUID.randomUUID().toString());
        RawMaterial insertedRawMaterial = rawMaterialRepositoryCustomImpl.insert(idExploitation, idFood, rawMaterial);

        return insertedRawMaterial;
    }

}
