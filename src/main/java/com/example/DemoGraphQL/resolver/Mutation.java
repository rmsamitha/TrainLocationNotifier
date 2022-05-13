package com.example.DemoGraphQL.resolver;

import com.example.DemoGraphQL.model.TrainEvent;
import com.example.DemoGraphQL.repository.TrainEventRepository;
import graphql.kickstart.tools.GraphQLMutationResolver;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.util.HashMap;

public class Mutation implements GraphQLMutationResolver {

    private TrainEventRepository trainEventRepository;
    public static HashMap<String, Boolean> subscriptionInitiated = new HashMap<>();

    private static final Log log = LogFactory.getLog(Mutation.class);

    public Mutation(TrainEventRepository trainEventRepository) {

        this.trainEventRepository = trainEventRepository;
    }

    public TrainEvent addTrainEvent(Long trainId, String currentStation, String time, String nextStation) {

        subscriptionInitiated.put(nextStation, true);
        log.info("Enabling subscriptions for Station:" + nextStation);

        TrainEvent trainEvent = new TrainEvent();
        trainEvent.setTrainId(trainId);
        trainEvent.setCurrentStation(currentStation);
        trainEvent.setNextStation(nextStation);
        trainEvent.setTime(time);

        trainEventRepository.save(trainEvent);
        return trainEvent;
    }
}
