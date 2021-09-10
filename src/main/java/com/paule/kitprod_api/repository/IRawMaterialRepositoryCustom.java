package com.paule.kitprod_api.repository;

import com.paule.kitprod_api.model.RawMaterial;
import java.util.List;

public interface IRawMaterialRepositoryCustom {
    public RawMaterial insert(String idExploitation, String idFood, RawMaterial rawMaterial);
    public List<RawMaterial> findAll(String idExploitation, String idFood);
    public boolean delete(String idExploitation, String idFood, String idRawMaterial);
}
