package com.example.study.practice.infra;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class MongoRepository {

	private final MongoTemplate mongoTemplate;

	public <T> List<T> findAll(Class<T> entityClass) {
		Query query = new Query().limit(100);
		return mongoTemplate.find(query, entityClass);
	}

	public <T> List<T> find(Class<T> entityClass, Query query) {
		return mongoTemplate.find(query, entityClass);
	}

	public <T> long count(Class<T> entityClass, Query query) {
		return mongoTemplate.count(query, entityClass);
	}
}
