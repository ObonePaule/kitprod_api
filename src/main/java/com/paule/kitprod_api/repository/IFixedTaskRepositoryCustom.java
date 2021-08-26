package com.paule.kitprod_api.repository;

import com.paule.kitprod_api.model.FixedTask;
import java.util.List;

public interface IFixedTaskRepositoryCustom {
    public FixedTask insert(String idExploitation, String idBuilding, String idLot, FixedTask fixedTask);
    public List<FixedTask> findAll(String idExploitation, String idBuilding, String idLot);
}
