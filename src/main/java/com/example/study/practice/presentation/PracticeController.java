package com.example.study.practice.presentation;

import com.example.study.practice.domain.Movies;
import com.example.study.practice.domain.Theaters;
import com.example.study.practice.domain.Users;
import com.example.study.practice.infra.MongoRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class PracticeController {

	private final MongoRepository mongoRepository;

	@GetMapping("/movies/find-all")
	public List<Movies> findAllMovies() {
		return mongoRepository.findAll(Movies.class);
	}

	@GetMapping("/users/find-all")
	public List<Users> findAllUsers() {
		return mongoRepository.findAll(Users.class);
	}

	@GetMapping("/theaters/find-all")
	public List<Users> findAllTheaters() {
		return mongoRepository.findAll(Theaters.class);
	}

	@GetMapping("/comments/find-all")
	public List<Users> findAllComments() {
		return mongoRepository.findAll(Theaters.class);
	}

	@GetMapping("/sessions/find-all")
	public List<Users> findAllSessions() {
		return mongoRepository.findAll(Theaters.class);
	}
}
