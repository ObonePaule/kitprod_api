package com.paule.kitprod_api.repository;

import com.paule.kitprod_api.model.Charge;
import java.util.List;

public interface IChargeRepositoryCustom {
    public Charge insert(String idExploitation, Charge charge);
    public List<Charge> findAll(String idExploitation);
}
