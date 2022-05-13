package com.example.DemoGraphQL.resolver;

import com.example.DemoGraphQL.model.TrainEvent;
import com.example.DemoGraphQL.repository.TrainEventRepository;
import graphql.kickstart.tools.GraphQLSubscriptionResolver;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import reactor.core.publisher.Flux;

import java.time.Duration;
import java.util.List;
import java.util.Random;
import java.util.logging.Logger;

public class Subscription implements GraphQLSubscriptionResolver {

    //Logger logger = new Logger(Subscription.class);
    private static final Log log = LogFactory.getLog(Subscription.class);
    private Flux<TrainEvent> trainReaching1;
    private TrainEventRepository trainEventRepository;


    public Subscription(TrainEventRepository trainEventRepository) {
        this.trainEventRepository = trainEventRepository;
    }

    public Publisher<TrainEvent> trainReaching(String nextStation) {
        Random random = new Random();

        Flux<TrainEvent> map;
        map = Flux.interval(Duration.ofSeconds(1))
                .map(num -> {
                    log.info("TTFFF");
                   // TrainEvent trainEventById1 = trainEventRepository.findById();

                    List<TrainEvent> all = trainEventRepository.findAll();
                    return all.get(all.size()-1);

//                    TrainEvent trainEvent = new TrainEvent(random.nextLong());
//                    trainEvent.setTime("12:33:44");
//                    trainEvent.setTrainId(33L);
//                    trainEvent.setNextStation("ggg");
//                    trainEvent.setCurrentStation("hhh");
 //                   return  trainEvent;
                });
        return map;
    }

}
