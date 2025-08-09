package com.example.study.practice.domain;


import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Getter
@NoArgsConstructor
@Document(collection = "sessions")
public class Sessions {
	private String id;
	@Field("user_id")
	private String userId;
	private String jwt;
}
