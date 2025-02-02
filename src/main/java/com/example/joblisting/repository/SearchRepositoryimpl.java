package com.example.joblisting.repository;

import java.util.List;

import org.bson.BsonDocument;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.convert.MongoConverter;
import org.springframework.stereotype.Component;

import com.example.joblisting.models.Post;
import com.mongodb.client.AggregateIterable;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

import java.util.ArrayList;
import java.util.Arrays;

@Component
public class SearchRepositoryimpl implements SearchRepository{
	
	@Autowired
	private MongoClient mongoClient;
	
	@Autowired
	MongoConverter convertor;
	@Override
	public List<Post> findByText(String text){
		final  List<Post> posts= new ArrayList<>();
		
		MongoDatabase database = mongoClient.getDatabase("fullstack");
		MongoCollection<Document> collection = database.getCollection("jobpost");

		AggregateIterable<Document> result = collection.aggregate(Arrays.asList(new Document("$search", 
		    new Document("index", "default")
		            .append("text", 
		    new Document("query", text)
		                .append("path", Arrays.asList("desc", "profile", "techs")))), 
		    new Document("$sort", 
		    new Document("exp", 1L)), 
		    new Document("$limit", 5L)));
		
		result.forEach( doc -> posts.add(convertor.read(Post.class, doc)) );
		
		
		
		
		return posts;
	}
}
