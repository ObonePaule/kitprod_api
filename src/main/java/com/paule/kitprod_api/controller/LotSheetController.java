package com.paule.kitprod_api.controller;

import com.paule.kitprod_api.model.LotSheet;
import com.paule.kitprod_api.model.SequenceGeneratorService;
import com.paule.kitprod_api.repository.LotSheetRepositoryCustomImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class LotSheetController {

    @Autowired
    private SequenceGeneratorService sequenceGeneratorService;

    @Autowired
    public LotSheetRepositoryCustomImpl lotSheetRepositoryCustomImpl;

    @GetMapping(value = "/lotSheets")
    public List<LotSheet> getAllLotSheets(@RequestParam long idExploitation, @RequestParam long idBuilding, @RequestParam long idLot ){
        return lotSheetRepositoryCustomImpl.findAll(idExploitation, idBuilding, idLot);
    }

    @PostMapping(value = "/lotSheets")
    public String createLotSheet( @RequestParam long idExploitation, @RequestParam long idBuilding, @RequestParam long idLot, @RequestBody LotSheet lotSheet){
        lotSheet.setId(sequenceGeneratorService.generateSequence(lotSheet.SEQUENCE_NAME));
        LotSheet insertedLotSheet = lotSheetRepositoryCustomImpl.insert(idExploitation, idBuilding, idLot, lotSheet);

        return "Lot created: "+lotSheet.getLoss();
    }

}
