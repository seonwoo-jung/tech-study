package com.example.study.practice.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "users") // 실제 몽고 DB 컬렉션 이름
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Users {
	@Id
    private String id; // 또는 ObjectId
    private String name;
	private String email;
	private String password;
}
