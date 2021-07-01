package com.paule.kitprod_api.repository;

import com.paule.kitprod_api.model.LotSheet;
import java.util.List;

public interface ILotSheetRepositoryCustom {
    public LotSheet insert(String idExploitation, String idBuilding, String idLot, LotSheet lotSheet);
    public List<LotSheet> findAll(String idExploitation, String idBuilding, String idLot);
}
