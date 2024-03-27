package com.artragazzi.workshopmongo.repository;

import com.artragazzi.workshopmongo.domain.User;
import org.springframework.stereotype.Repository;
import org.springframework.data.mongodb.repository.MongoRepository;


@Repository
public interface UserRepository extends MongoRepository<User,String> {
    
}

