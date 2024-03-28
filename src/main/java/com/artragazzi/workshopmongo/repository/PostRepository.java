package com.artragazzi.workshopmongo.repository;

import com.artragazzi.workshopmongo.domain.Post;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface PostRepository extends MongoRepository<Post,String> {
    
}

