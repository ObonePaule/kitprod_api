package com.paule.kitprod_api.repository;

import com.paule.kitprod_api.model.Exploitation;
import com.paule.kitprod_api.model.Lot;
import com.paule.kitprod_api.model.LotSheet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class LotSheetRepositoryCustomImpl implements ILotSheetRepositoryCustom {

    @Autowired
    public ExploitationRepository exploitationRepository;

    @Autowired
    public LotRepositoryCustomImpl lotRepositoryCustomImpl;

    @Override
    public LotSheet insert(String idExploitation, String idBuilding, String idLot, LotSheet lotSheet) {
        Optional<Exploitation> exploitation = exploitationRepository.findById(idExploitation);

        if (exploitation.isPresent()) {
            Exploitation existingExploitation = exploitation.get();
            existingExploitation.addLotSheet(idBuilding, idLot, lotSheet);
            exploitationRepository.save(existingExploitation);

            return  lotSheet;
        }
        return null;
    }

    @Override
    public List<LotSheet> findAll(String idExploitation, String idBuilding, String idLot) {
        Lot lot = lotRepositoryCustomImpl.findById(idExploitation, idBuilding, idLot);

        return lot.getLotSheets();
    }
}
