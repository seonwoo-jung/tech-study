package com.example.study.practice.presentation;

import com.example.study.practice.application.PracticeService;
import com.example.study.practice.domain.Comments;
import com.example.study.practice.domain.Movies;
import com.example.study.practice.domain.Sessions;
import com.example.study.practice.domain.Theaters;
import com.example.study.practice.domain.Users;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class PracticeController {

	private final PracticeService practiceService;

	@GetMapping("/movies/find-all")
	public List<Movies> findAllMovies() {
		return practiceService.findAll(Movies.class);
	}

	@GetMapping("/users/find-all")
	public List<Users> findAllUsers() {
		return practiceService.findAll(Users.class);
	}

	@GetMapping("/theaters/find-all")
	public List<Users> findAllTheaters() {
		return practiceService.findAll(Theaters.class);
	}

	@GetMapping("/comments/find-all")
	public List<Users> findAllComments() {
		return practiceService.findAll(Comments.class);
	}

	@GetMapping("/sessions/find-all")
	public List<Users> findAllSessions() {
		return practiceService.findAll(Sessions.class);
	}
}
