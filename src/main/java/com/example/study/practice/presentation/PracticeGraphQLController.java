package com.example.study.practice.presentation;

import com.example.study.practice.application.PracticeService;
import com.example.study.practice.domain.Comments;
import com.example.study.practice.domain.Movies;
import com.example.study.practice.domain.Sessions;
import com.example.study.practice.domain.Theaters;
import com.example.study.practice.domain.Users;
import io.micrometer.common.util.StringUtils;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

@Controller
@RequiredArgsConstructor
public class PracticeGraphQLController {

	private final PracticeService practiceService;

	@QueryMapping(name = "movies")
	public List<Movies> movies(
			@Argument String title,
			@Argument Integer year
	) {
		Query q = new Query();
		if (title != null) {
			q.addCriteria(Criteria.where("title").regex(title, "i"));
		}
		if (year != null) {
			q.addCriteria(Criteria.where("year").is(year));
		}
		q.limit(100).skip(0);

		return practiceService.find(Movies.class, q);
	}

	@QueryMapping(name = "theaters")
	public List<Theaters> theaters(@Argument Integer limit, @Argument Integer offset) {
		Query q = new Query().limit(limit == null ? 100 : limit)
			.skip(offset == null ? 0 : offset);
		return practiceService.find(Theaters.class, q);
	}

	@QueryMapping(name = "users")
	public List<Users> users(@Argument Integer limit, @Argument Integer offset) {
		Query q = new Query().limit(limit == null ? 100 : limit).skip(offset == null ? 0 : offset);
		return practiceService.find(Users.class, q);
	}

	@QueryMapping(name = "comments")
	public List<Comments> comments(
			@Argument Integer limit,
			@Argument Integer offset,
			@Argument String name
	) {
		Query q = new Query();
		q.limit(limit == null ? 100 : limit).skip(offset == null ? 0 : offset);
		if (StringUtils.isNotBlank(name)) {
			q.addCriteria(Criteria.where("name").is(name));
		}
		return practiceService.find(Comments.class, q);
	}

	@QueryMapping(name = "sessions")
	public List<Sessions> sessions(
			@Argument Integer limit,
			@Argument Integer offset,
			@Argument String userId
	) {
		Query q = new Query();
		if (userId != null) {
			q.addCriteria(Criteria.where("user_id").is(userId));
		}
		q.limit(limit == null ? 100 : limit).skip(offset == null ? 0 : offset);
		return practiceService.find(Sessions.class, q);
	}
}