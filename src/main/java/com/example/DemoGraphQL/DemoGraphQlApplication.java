package com.example.DemoGraphQL;

import com.example.DemoGraphQL.repository.TrainEventRepository;
import com.example.DemoGraphQL.resolver.Mutation;
import com.example.DemoGraphQL.resolver.Query;
import com.example.DemoGraphQL.resolver.Subscription;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DemoGraphQlApplication extends SpringBootServletInitializer {

    private static final Log log = LogFactory.getLog(DemoGraphQlApplication.class);

    public static void main(String[] args) {

        log.info("running main");
        Mutation.subscriptionInitiated.put("Cardiff", false);
        Mutation.subscriptionInitiated.put("Manchester", false);
        Mutation.subscriptionInitiated.put("Edinburgh", false);
        Mutation.subscriptionInitiated.put("Glasgow", false);
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

    @Bean
    public Subscription subscription(TrainEventRepository trainEventRepository) {

        return new Subscription(trainEventRepository);
    }

//	@Bean
//	public CommandLineRunner demo(TrainEventRepository trainEventRepository) {
//		return (args) -> {
//			TrainEvent demoInitialTrainEvent = new TrainEvent(55L, "London", "12:33:44", "Cardiff");
//			trainEventRepository.save(demoInitialTrainEvent);
//		};
//	}

}
