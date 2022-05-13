package com.example.DemoGraphQL.resolver;

import com.example.DemoGraphQL.model.TrainEvent;
import com.example.DemoGraphQL.repository.TrainEventRepository;
import graphql.kickstart.tools.GraphQLMutationResolver;

public class Mutation implements GraphQLMutationResolver {
    private TrainEventRepository trainEventRepository;

    public Mutation(TrainEventRepository trainEventRepository) {
        this.trainEventRepository = trainEventRepository;
    }

    public TrainEvent addTrainEvent(Long trainId, String currentStation, String time,String nextStation) {
        TrainEvent trainEvent = new TrainEvent();
        trainEvent.setTrainId(trainId);
        trainEvent.setCurrentStation(currentStation);
        trainEvent.setNextStation(nextStation);
        trainEvent.setTime(time);

        trainEventRepository.save(trainEvent);
        return trainEvent;
    }
}
