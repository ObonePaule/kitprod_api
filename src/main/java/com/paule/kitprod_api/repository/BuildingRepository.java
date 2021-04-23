package com.paule.kitprod_api.repository;

import com.paule.kitprod_api.model.Building;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BuildingRepository extends MongoRepository<Building,Long> {
}
