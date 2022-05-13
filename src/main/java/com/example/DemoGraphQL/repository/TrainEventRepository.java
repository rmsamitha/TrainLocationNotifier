package com.example.DemoGraphQL.repository;

import com.example.DemoGraphQL.model.TrainEvent;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TrainEventRepository extends JpaRepository<TrainEvent, Long> {
}
