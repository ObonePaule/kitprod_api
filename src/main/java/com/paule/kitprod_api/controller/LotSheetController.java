package com.paule.kitprod_api.controller;

import com.paule.kitprod_api.model.LotSheet;
import com.paule.kitprod_api.model.SequenceGeneratorService;
import com.paule.kitprod_api.repository.LotSheetRepositoryCustomImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
public class LotSheetController {

    @Autowired
    private SequenceGeneratorService sequenceGeneratorService;

    @Autowired
    public LotSheetRepositoryCustomImpl lotSheetRepositoryCustomImpl;

    @GetMapping(value = "/lotSheets")
    public List<LotSheet> getAllLotSheets(@RequestParam String idExploitation, @RequestParam String idBuilding, @RequestParam String idLot ){

        return lotSheetRepositoryCustomImpl.findAll(idExploitation, idBuilding, idLot);
    }

    @PostMapping(value = "/lotSheets")
    public LotSheet createLotSheet( @RequestParam String idExploitation, @RequestParam String idBuilding, @RequestParam String idLot, @RequestBody LotSheet lotSheet){
        lotSheet.setId(UUID.randomUUID().toString());
        LotSheet insertedLotSheet = lotSheetRepositoryCustomImpl.insert(idExploitation, idBuilding, idLot, lotSheet);

        return insertedLotSheet;
    }

}
