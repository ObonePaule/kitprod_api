package com.paule.kitprod_api.repository;

import com.paule.kitprod_api.model.Building;
import java.util.List;

public interface IBuildingRepositoryCustom {
    public Building insert(long idExploitation, Building building);
    public List<Building> findAll(long idExploitation);
    public Building findById(long idExploitation, long idBuilding);
}
