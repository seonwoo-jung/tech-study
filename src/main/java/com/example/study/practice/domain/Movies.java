package com.example.study.practice.domain;

import java.util.Date;
import java.util.List;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@NoArgsConstructor
@Document(collection = "movies")
public class Movies {

    @Id
    private String id; // MongoDB ObjectId (자동 매핑)
    private String plot;
    private List<String> genres;
    private Integer runtime;
    private List<String> cast;
	private Integer num_mflix_comments;

	private String title;
	private String fullplot;
	private List<String> languages;
	private String poster;

	private Date released; // ?

	private List<String> directors;
	private String rated;
	private Awards awards;
	private String lastupdated;
	private String year;

	private Imdb imdb;
	private List<String> countries;
	private String type;
	private Tomatoes tomatoes;

    @Getter
    @NoArgsConstructor
    public static class Awards {
        private Integer wins;
        private Integer nominations;
        private String text;
    }

    @Getter
    @NoArgsConstructor
    public static class Imdb {
        private Double rating;
        private Integer votes;
        private Integer id;
    }

    @Getter
    @NoArgsConstructor
    public static class Tomatoes {
        private Viewer viewer;
        private Integer fresh;
        private Critic critic;
        private Integer rotten;
        private Date lastUpdated;

        @Getter
        @NoArgsConstructor
        public static class Viewer {
            private Double rating;
            private Integer numReviews;
            private Integer meter;
        }

        @Getter
        @NoArgsConstructor
        public static class Critic {
            private Double rating;
            private Integer numReviews;
            private Integer meter;
        }
    }
}
