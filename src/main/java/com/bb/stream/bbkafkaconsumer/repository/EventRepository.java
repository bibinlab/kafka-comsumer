package com.bb.stream.bbkafkaconsumer.repository;


import com.bb.stream.bbkafkaconsumer.repository.entity.Event;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EventRepository extends ReactiveCrudRepository<Event, String> {


}
