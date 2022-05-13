package com.example.DemoGraphQL.resolver;

import com.example.DemoGraphQL.model.TrainEvent;
import com.example.DemoGraphQL.repository.TrainEventRepository;
import graphql.kickstart.tools.GraphQLQueryResolver;

public class Query implements GraphQLQueryResolver {

    private TrainEventRepository trainEventRepository;

    public Query(TrainEventRepository trainEventRepository) {

        this.trainEventRepository = trainEventRepository;
    }

    public Iterable<TrainEvent> getAllTrainEvents() {

        return trainEventRepository.findAll();
    }
}
