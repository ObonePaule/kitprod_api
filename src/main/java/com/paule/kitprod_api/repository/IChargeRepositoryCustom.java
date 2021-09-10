package com.paule.kitprod_api.repository;

import com.paule.kitprod_api.model.Building;
import com.paule.kitprod_api.model.Charge;
import java.util.List;

public interface IChargeRepositoryCustom {
    public Charge insert(String idExploitation, Charge charge);
    public List<Charge> findAll(String idExploitation);
    public boolean delete(String idExploitation, List<Charge> charges);
    public List<Charge> update(String idExploitation, List<Charge> updatedCharges);
}
