package com.example.study.config;

import com.example.study.practice.application.PracticeService;
import com.example.study.practice.domain.Movies;
import com.example.study.practice.domain.Users;
import org.dataloader.DataLoaderFactory;
import org.dataloader.DataLoaderRegistry;
import org.dataloader.MappedBatchLoader;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

@Configuration
public class DataLoaderConfig {

    public static final String USER_BY_ID = "USER_BY_ID";
    public static final String MOVIE_BY_ID = "MOVIE_BY_ID";

    @Bean
    DataLoaderRegistry dataLoaderRegistry(PracticeService<?> practiceService) {
        DataLoaderRegistry registry = new DataLoaderRegistry();

        // Users
        MappedBatchLoader<String, Users> userLoader = keys -> CompletableFuture.supplyAsync(() -> {
            Query q = new Query(Criteria.where("_id").in(keys));
            List<Users> users = practiceService.find(Users.class, q);
            return users.stream().collect(Collectors.toMap(Users::getId, u -> u));
        });

        // Movies
        MappedBatchLoader<String, Movies> movieLoader = keys -> CompletableFuture.supplyAsync(() -> {
            Query q = new Query(Criteria.where("_id").in(keys));
            List<Movies> movies = practiceService.find(Movies.class, q);
            return movies.stream().collect(Collectors.toMap(Movies::getId, m -> m));
        });

        // ✅ 변경: DataLoaderFactory 사용
        registry.register(USER_BY_ID, DataLoaderFactory.newMappedDataLoader(userLoader));
        registry.register(MOVIE_BY_ID, DataLoaderFactory.newMappedDataLoader(movieLoader));
        return registry;
    }
}
