package com.example.study.practice.domain;

import java.util.Date;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Getter
@NoArgsConstructor
@Document(collection = "comments")
public class Comments {

    @Id
    private String id; // MongoDB ObjectId (자동 매핑)
	private String name;
	private String email;
	@Field("movie_id") // JSON 필드명과 자바 필드명이 다를 경우
    private String movieId;
	private String text;
	private Date date;
}
