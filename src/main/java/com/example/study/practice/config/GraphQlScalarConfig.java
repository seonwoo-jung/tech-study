package com.example.study.practice.config;

import graphql.scalars.ExtendedScalars;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.graphql.execution.RuntimeWiringConfigurer;

@Configuration
public class GraphQlScalarConfig {

    @Bean
    public RuntimeWiringConfigurer runtimeWiringConfigurer() {
        return builder -> builder
            .scalar(ExtendedScalars.DateTime) // ISO-8601 OffsetDateTime/Instant 매핑
            // .scalar(ExtendedScalars.Date)   // 필요 시 날짜만
            // .scalar(ExtendedScalars.Time)   // 필요 시 시간만
        ;
    }
}