package com.paule.kitprod_api.repository;

import com.paule.kitprod_api.model.FixedTask;
import java.util.List;

public interface IFixedTaskRepositoryCustom {
    public FixedTask insert(long idExploitation, FixedTask fixedTask);
    public List<FixedTask> findAll(long idExploitation);
}
