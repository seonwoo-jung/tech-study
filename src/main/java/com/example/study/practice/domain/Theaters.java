package com.example.study.practice.domain;

import java.util.List;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@NoArgsConstructor
@Document(collection = "theaters")
public class Theaters {

    @Id
    private String id; // MongoDB ObjectId (자동 매핑)
	private Long theaterId;
	private Location location;

    @Getter
    @NoArgsConstructor
	private static class Location {
		private Address address;
		private Geo geo;
	}

    @Getter
    @NoArgsConstructor
	private static class Address {
		private String street1;
		private String city;
		private String state;
		private String zipcode;
	}

    @Getter
    @NoArgsConstructor
	private static class Geo {
		private String type;
		private List<Double> coordinates;
	}
}
