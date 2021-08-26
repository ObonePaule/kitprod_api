package com.paule.kitprod_api.repository;

import com.paule.kitprod_api.model.Exploitation;
import com.paule.kitprod_api.model.FixedTask;
import com.paule.kitprod_api.model.Lot;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class FixedTaskRepositoryCustomImpl implements IFixedTaskRepositoryCustom{

    @Autowired public ExploitationRepository exploitationRepository;

    @Autowired public LotRepositoryCustomImpl lotRepositoryCustomImpl;

    @Override
    public FixedTask insert(String idExploitation, String idBuilding, String idLot, FixedTask fixedTask) {
        Optional<Exploitation> exploitation = exploitationRepository.findById(idExploitation);

        if (exploitation.isPresent()) {
            Exploitation existingExploitation = exploitation.get();
            existingExploitation.addFixedTask(idBuilding, idLot, fixedTask);
            exploitationRepository.save(existingExploitation);

            return  fixedTask;
        }
        return null;
    }

    @Override
    public List<FixedTask> findAll(String idExploitation, String idBuilding, String idLot) {
        Lot lot = lotRepositoryCustomImpl.findById(idExploitation, idBuilding, idLot);

        return lot.getFixedTasks();
    }
}

