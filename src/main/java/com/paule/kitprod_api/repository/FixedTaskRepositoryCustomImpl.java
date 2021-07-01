package com.paule.kitprod_api.repository;

import com.paule.kitprod_api.model.Exploitation;
import com.paule.kitprod_api.model.FixedTask;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class FixedTaskRepositoryCustomImpl implements IFixedTaskRepositoryCustom{

    @Autowired public ExploitationRepository exploitationRepository;

    @Override
    public FixedTask insert(String idExploitation, FixedTask fixedTask) {
        Optional<Exploitation> exploitation = exploitationRepository.findById(idExploitation);

        if (exploitation.isPresent()){
            Exploitation existingExploitation = exploitation.get();
            existingExploitation.addFixedTask(fixedTask);
            exploitationRepository.save(existingExploitation);

            return fixedTask;
        }

        return null;
    }

    @Override
    public List<FixedTask> findAll(String idExploitation) {
        Optional<Exploitation> exploitation = exploitationRepository.findById(idExploitation);

        if (exploitation.isPresent()){
            Exploitation existingExploitation = exploitation.get();

            return existingExploitation.getFixedTasks();
        }

        return null;
    }
}

