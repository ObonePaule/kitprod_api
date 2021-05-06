package com.paule.kitprod_api.repository;

import com.paule.kitprod_api.model.RawMaterial;
import java.util.List;

public interface IRawMaterialRepositoryCustom {
    public RawMaterial insert(long idExploitation, long idFood, RawMaterial rawMaterial);
    public List<RawMaterial> findAll(long idExploitation, long idFood);
}
