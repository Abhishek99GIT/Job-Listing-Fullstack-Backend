package com.example.joblisting.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.joblisting.models.Post;

@Repository
public interface PostRepository extends MongoRepository<Post,String> {
	
}
