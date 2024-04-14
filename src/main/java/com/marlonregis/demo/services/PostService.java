package com.marlonregis.demo.services;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.marlonregis.demo.domain.Post;
import com.marlonregis.demo.repository.PostRepository;
import com.marlonregis.demo.services.exception.ObjectNotFoundException;

@Service
public class PostService {

	@Autowired
	private PostRepository repo;
	
	
	public Post findById(String id) {
		Post post = repo.findById(id).orElse(null);
		
		if (post == null ) {
			throw new ObjectNotFoundException("Objeto não encontrado");
		}
		
		return post;
	}
	
	//http://localhost:8080/posts/titlesearch?text=frefref example of query on postman
	public List<Post> findByTitle(String text){
		return repo.searchTitle(text);
	}
	
	public List<Post> fullsearch(String text, Date minDate, Date maxDate){
		maxDate = new Date(maxDate.getTime() + 24 * 60 *60 * 1000);
		return repo.fullSearch(text, minDate, maxDate);
	}
}
