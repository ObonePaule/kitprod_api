package com.paule.kitprod_api.repository;

import com.paule.kitprod_api.model.Building;
import com.paule.kitprod_api.model.Employee;

import java.util.List;

public interface IBuildingRepositoryCustom {
    public Building insert(String idExploitation, Building building);
    public List<Building> findAll(String idExploitation);
    public Building findById(String idExploitation, String idBuilding);
    public boolean delete(String idExploitation, String idBuilding);
    public Building update(String idExploitation, String idBuilding, Building building);
}
