package com.paule.kitprod_api.repository;

import com.paule.kitprod_api.model.Charge;
import com.paule.kitprod_api.model.Exploitation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ChargeRepositoryCustomImpl implements IChargeRepositoryCustom {

    @Autowired ExploitationRepository exploitationRepository;

    @Override
    public Charge insert(long idExploitation, Charge charge) {
        Optional<Exploitation> exploitation = exploitationRepository.findById(idExploitation);

        if (exploitation.isPresent()) {
            Exploitation existingExploitation = exploitation.get();

            existingExploitation.addCharge(charge);
            exploitationRepository.save(existingExploitation);

            return charge;
        }
        return null;
    }

    @Override
    public List<Charge> findAll(long idExploitation) {
        Optional<Exploitation> exploitation = exploitationRepository.findById(idExploitation);
        if (exploitation.isPresent()) {
            Exploitation existingExploitation = exploitation.get();

            return existingExploitation.getCharges();
        }
        return null;
    }
}
