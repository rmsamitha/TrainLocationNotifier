package com.example.DemoGraphQL.resolver;

import com.example.DemoGraphQL.model.TrainEvent;
import com.example.DemoGraphQL.repository.TrainEventRepository;
import graphql.kickstart.tools.GraphQLSubscriptionResolver;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.reactivestreams.Publisher;
import reactor.core.publisher.Flux;

import java.time.Duration;
import java.util.List;

public class Subscription implements GraphQLSubscriptionResolver {

    private static final Log log = LogFactory.getLog(Subscription.class);
    private TrainEventRepository trainEventRepository;

    public Subscription(TrainEventRepository trainEventRepository) {

        this.trainEventRepository = trainEventRepository;
    }

    public Publisher<TrainEvent> trainReaching(String nextStation) {

        log.info("in trainReaching method");

        // wait until any entry is added to match nextStation
        while (Mutation.subscriptionInitiated.get(nextStation) == false) {
            // loop to wait
        }
        //subscriptionInitiated.clear();
        //initialize other all NextStations here to false again

        Flux<TrainEvent> map;
        map = Flux.interval(Duration.ofSeconds(1))
                .map(item -> {
                    //log.info("New Flux interval iteration");
                    List<TrainEvent> allTrainEvents = trainEventRepository.findAll();
                    TrainEvent lastTrainEvent = allTrainEvents.get(allTrainEvents.size() - 1);
                    if (lastTrainEvent.getNextStation().equals(nextStation)) {
                       // log.info("Event sending to to the subscriber: next station:" + lastTrainEvent.getNextStation());
                        return lastTrainEvent;
                    } else {
                        //log.info("Looping ");
                        for (int i = allTrainEvents.size() - 1; i >= 0; i--) {
                            if (allTrainEvents.get(i).getNextStation().equals(nextStation)) {
                                return allTrainEvents.get(i);
                            }
                        }
                    }
                    return lastTrainEvent;
                });
        return map;
    }

}
