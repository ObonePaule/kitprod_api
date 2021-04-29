package com.paule.kitprod_api.repository.repoSave;

import com.paule.kitprod_api.model.Charge;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChargeRepository extends MongoRepository<Charge, Long> {

}
