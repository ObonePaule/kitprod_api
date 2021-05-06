package com.paule.kitprod_api.repository;

import com.paule.kitprod_api.model.Lot;

import java.util.List;

public interface ILotRepositoryCustom {
    public Lot insert(long idExploitation, long idBuilding, Lot lot);
    public List<Lot> findAll(long idExploitation, long idBuilding);
    public Lot findById(long idExploitation, long idBuilding, long idLot);
}
