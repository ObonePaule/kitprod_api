package com.paule.kitprod_api.repository;

import com.paule.kitprod_api.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, String> {
}
