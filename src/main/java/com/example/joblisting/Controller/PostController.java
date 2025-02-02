package com.example.joblisting.Controller;

import java.io.IOException;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.joblisting.models.Post;
import com.example.joblisting.repository.PostRepository;
import com.example.joblisting.repository.SearchRepository;

import io.swagger.v3.oas.annotations.parameters.RequestBody;
import springfox.documentation.annotations.ApiIgnore;

@CrossOrigin(origins="http://localhost:4200")
@RestController
public class PostController {
	@ApiIgnore
	@RequestMapping(value="/")
	public void redirect(HttpServletResponse response) throws IOException {
		response.sendRedirect("./swagger-ui/index.html");
	
	}
	
	@Autowired
	PostRepository repo;
	
	@Autowired
	SearchRepository srepo;
	
	@GetMapping("/Allposts")
	@CrossOrigin
    public List<Post> getAllPosts()
    {
        return repo.findAll();
    }
	
	@GetMapping("/posts/{text}")
	@CrossOrigin
    public List<Post> search(@PathVariable String text)
    {
        return srepo.findByText(text);
    }
	
	@PostMapping("/post")
	@CrossOrigin
	public ResponseEntity<Post> addPost(@RequestBody Post post) {
		System.out.println("Received Job: " + post);
		return ResponseEntity.ok(repo.save(post));
	}
}

