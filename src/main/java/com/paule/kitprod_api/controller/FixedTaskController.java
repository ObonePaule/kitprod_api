package com.paule.kitprod_api.controller;

import com.paule.kitprod_api.model.Charge;
import com.paule.kitprod_api.model.FixedTask;
import com.paule.kitprod_api.model.SequenceGeneratorService;
import com.paule.kitprod_api.repository.FixedTaskRepositoryCustomImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
public class FixedTaskController {

    @Autowired public SequenceGeneratorService sequenceGeneratorService;

    @Autowired public FixedTaskRepositoryCustomImpl fixedTaskRepositoryCustomImpl;

    @GetMapping(value = "/fixedtasks")
    public List<FixedTask> getAllFixedTask(@RequestParam String idExploitation){

        return fixedTaskRepositoryCustomImpl.findAll(idExploitation);
    }

    @PostMapping(value = "/fixedtasks")
    public void createFixedTask(@RequestParam String idExploitation, @RequestBody ArrayList<FixedTask> fixedTasks){
        for (int i=0 ; i<fixedTasks.size(); i++) {
            FixedTask fixedTask = fixedTasks.get(i);
            fixedTask.setId(UUID.randomUUID().toString());
            FixedTask insertedFixedTask = fixedTaskRepositoryCustomImpl.insert(idExploitation, fixedTask);
        }
    }

}
