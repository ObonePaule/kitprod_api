package com.paule.kitprod_api.repository;

import com.paule.kitprod_api.model.Lot;
import java.util.List;

public interface ILotRepositoryCustom {
    public Lot insert(String idExploitation, String idBuilding, Lot lot);
    public List<Lot> findAll(String idExploitation, String idBuilding);
    public Lot findById(String idExploitation, String idBuilding, String idLot);
}
