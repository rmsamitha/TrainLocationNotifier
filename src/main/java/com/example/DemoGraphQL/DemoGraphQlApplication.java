package com.example.DemoGraphQL;

import com.example.DemoGraphQL.repository.TrainEventRepository;
import com.example.DemoGraphQL.resolver.Mutation;
import com.example.DemoGraphQL.resolver.Query;
import graphql.ExceptionWhileDataFetching;
import graphql.GraphQLError;
import graphql.kickstart.execution.error.GraphQLErrorHandler;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@SpringBootApplication
public class DemoGraphQlApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(DemoGraphQlApplication.class, args);
	}

	@Bean
	public Query query(TrainEventRepository trainEventRepository) {
		return new Query(trainEventRepository);
	}

	@Bean
	public Mutation mutation(TrainEventRepository trainEventRepository) {
		return new Mutation(trainEventRepository);
	}
}
