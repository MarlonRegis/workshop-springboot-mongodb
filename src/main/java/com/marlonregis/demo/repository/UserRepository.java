package com.marlonregis.demo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import com.marlonregis.demo.domain.User;

@Repository
public interface UserRepository extends MongoRepository<User, String> {

}
