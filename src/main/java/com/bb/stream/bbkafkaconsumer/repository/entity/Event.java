package com.bb.stream.bbkafkaconsumer.repository.entity;

import lombok.Builder;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Builder
public class Event {
    @Id
    String id;
    String timestamp;
    String key;
    String payload;
}
