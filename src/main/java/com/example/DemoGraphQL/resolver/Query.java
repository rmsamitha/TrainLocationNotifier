package com.example.DemoGraphQL.resolver;

import com.example.DemoGraphQL.model.TrainEvent;
import com.example.DemoGraphQL.repository.TrainEventRepository;
import graphql.kickstart.tools.GraphQLQueryResolver;

public class Query implements GraphQLQueryResolver {
//    private BookRepository bookRepository;
//    private AuthorRepository authorRepository;
    private TrainEventRepository trainEventRepository;

    public Query(TrainEventRepository trainEventRepository) {
//        this.authorRepository = authorRepository;
//        this.bookRepository = bookRepository;
        this.trainEventRepository = trainEventRepository;
    }

//    public Iterable<Book> findAllBooks() {
//        return bookRepository.findAll();
//    }
//
//    public long countBooks() {
//        return bookRepository.count();
//    }
//
//    public Iterable<Author> findAllAuthors() {
//        return authorRepository.findAll();
//    }
//
//    public long countAuthors() {
//        return authorRepository.count();
//    }

    public Iterable<TrainEvent> getAllTrainEvents() {
        return trainEventRepository.findAll();
    }

//    public Iterable<TrainEvent> getAddTrainEvent() {
//        return trainEventRepository.findAll();
//    }
}
