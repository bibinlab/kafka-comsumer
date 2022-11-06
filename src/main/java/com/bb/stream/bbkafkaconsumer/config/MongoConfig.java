package com.bb.stream.bbkafkaconsumer.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableReactiveMongoRepositories;

@Configuration
@EnableReactiveMongoRepositories(basePackages = "com.bb.stream.bbkafkaconsumer.repository")
public class MongoConfig {
}
