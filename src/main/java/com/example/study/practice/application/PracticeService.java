package com.example.study.practice.application;

import com.example.study.practice.infra.MongoRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PracticeService<T> {

	private final MongoRepository mongoRepository;

	public <T> List<T> findAll(Class<T> entityClass) {
		return mongoRepository.findAll(entityClass);
	}

	public <T> List<T> find(Class<T> entityClass, Query query) {
		return mongoRepository.find(entityClass, query);
	}

	public <T> long count(Class<T> entityClass, Query query) {
		return mongoRepository.count(entityClass, query);
	}
}
