package com.example.joblisting.repository;
import java.util.List;
import com.example.joblisting.models.Post;

public interface SearchRepository {
	
	List<Post> findByText(String text);
}
