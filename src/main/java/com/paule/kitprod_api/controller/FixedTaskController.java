package com.paule.kitprod_api.controller;

import com.paule.kitprod_api.model.FixedTask;
import com.paule.kitprod_api.model.SequenceGeneratorService;
import com.paule.kitprod_api.repository.FixedTaskRepositoryCustomImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class FixedTaskController {

    @Autowired public SequenceGeneratorService sequenceGeneratorService;

    @Autowired public FixedTaskRepositoryCustomImpl fixedTaskRepositoryCustomImpl;

    @GetMapping(value = "/fixedtasks")
    public List<FixedTask> getAllFixedTask(@RequestParam long idExploitation){
        return fixedTaskRepositoryCustomImpl.findAll(idExploitation);
    }

    @PostMapping(value = "/fixedtasks")
    public String createFixedTask(@RequestParam long idExploitation, @RequestBody FixedTask fixedTask){
        fixedTask.setId(sequenceGeneratorService.generateSequence(fixedTask.SEQUENCE_NAME));
        FixedTask insertedFixedTask = fixedTaskRepositoryCustomImpl.insert(idExploitation, fixedTask);

        return "Fixed task created: "+insertedFixedTask.getFixedTaskType().label;
    }

}
