package com.paule.kitprod_api.repository;

import com.paule.kitprod_api.model.Charge;
import com.paule.kitprod_api.model.Exploitation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class ChargeRepositoryCustomImpl implements IChargeRepositoryCustom {

    @Autowired ExploitationRepository exploitationRepository;

    @Override
    public Charge insert(String idExploitation, Charge charge) {
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
    public List<Charge> findAll(String idExploitation) {
        Optional<Exploitation> exploitation = exploitationRepository.findById(idExploitation);

        if (exploitation.isPresent()) {
            Exploitation existingExploitation = exploitation.get();

            return existingExploitation.getCharges();
        }
        return null;
    }

    @Override
    public boolean delete(String idExploitation, List<Charge> charges) {
        boolean wasRemoved = false;
        Optional<Exploitation> exploitation = exploitationRepository.findById(idExploitation);

        if (exploitation.isPresent()) {
            Exploitation existingExploitation = exploitation.get();
            wasRemoved = existingExploitation.removeCharges(charges);
            exploitationRepository.save(existingExploitation);

            return wasRemoved;
        }

        return wasRemoved;
    }

    @Override
    public List<Charge> update(String idExploitation, List<Charge> updatedCharges) {
        Optional<Exploitation> exploitation = exploitationRepository.findById(idExploitation);

        if (exploitation.isPresent()) {
            Exploitation existingExploitation = exploitation.get();
            List<Charge> updatedChargesList = existingExploitation.getCharges().stream().peek(charge -> {
                for (Charge updatedCharge: updatedCharges){
                    if (charge.getChargeType().equals(updatedCharge.getChargeType())) {
                        charge.setValue(updatedCharge.getValue());

                        updatedCharge.setId(charge.getId());
                    }
                }
            }).collect(Collectors.toList());

                existingExploitation.setCharges(updatedCharges);
                exploitationRepository.save(existingExploitation);

                return updatedChargesList;
        }
        return null;
    }
}
