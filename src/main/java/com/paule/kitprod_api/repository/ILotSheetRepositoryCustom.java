package com.paule.kitprod_api.repository;

import com.paule.kitprod_api.model.LotSheet;
import java.util.List;

public interface ILotSheetRepositoryCustom {
    public LotSheet insert(long idExploitation, long idBuilding, long idLot, LotSheet lotSheet);
    public List<LotSheet> findAll(long idExploitation, long idBuilding, long idLot);
}
