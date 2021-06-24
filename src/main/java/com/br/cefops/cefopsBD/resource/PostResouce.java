package com.br.cefops.cefopsBD.resource;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.br.cefops.cefopsBD.domain.Posts;
import com.br.cefops.cefopsBD.repository.PostInterface;

@RestController
@CrossOrigin
public class PostResouce {
	@Autowired
	PostInterface postsinterface;
	
	@RequestMapping(value = "/post", method = RequestMethod.GET)
	public ResponseEntity<?> obterPostes() {
		List<Posts> posts = postsinterface.findAll();
		return ResponseEntity.status(HttpStatus.OK).body(posts);
	}
	
	@RequestMapping(value = "/post/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> obterPostID(@PathVariable Integer id) {
		Optional<Posts> optPosts = postsinterface.findById(id);
		if (optPosts.isPresent()) {
			return ResponseEntity.status(HttpStatus.OK).body(optPosts.get());
		}
		return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
	}
	

	@ResponseBody
	@RequestMapping(value = "/post", method = RequestMethod.POST)
	public ResponseEntity<?> novoPost(@RequestBody Posts post) {
		Optional<Posts> optposts = postsinterface.findById(post.getId());
		if (optposts.isPresent())
			return ResponseEntity.status(HttpStatus.CONFLICT).body("");
		postsinterface.save(post);
		return ResponseEntity.status(HttpStatus.CREATED).body(post);
	}
	
	
	@ResponseBody
	@RequestMapping(value = "/post/{id}", method = RequestMethod.PUT)
	public ResponseEntity<?> alterarpost(@PathVariable Integer id, @RequestBody Posts postNovo) {
		Optional<Posts> optPost = postsinterface.findById(id);
		if (!optPost.isPresent())
			return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Não encontrado");

		Posts postCorrente = optPost.get();
			postCorrente.setTitle(postNovo.getTitle());
			postCorrente.setPoste(postNovo.getPoste());
		
		postsinterface.save(postCorrente);
		return ResponseEntity.status(HttpStatus.OK).body(postCorrente);
	}

	
	

}
