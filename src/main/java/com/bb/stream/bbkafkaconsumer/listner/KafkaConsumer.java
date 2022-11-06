package com.bb.stream.bbkafkaconsumer.listner;

import com.bb.stream.bbkafkaconsumer.repository.EventRepository;
import com.bb.stream.bbkafkaconsumer.repository.entity.Event;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.UUID;

@Component
@Slf4j
public class KafkaConsumer {


    private final EventRepository eventRepository;

    public KafkaConsumer(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    @KafkaListener(topics = "${topicName}", groupId = "${groupId}",containerFactory = "kafkaListenerContainerFactory")
    public void listen(ConsumerRecord<Integer, String> consumerRecord, Acknowledgment ack) {
        log.info("Received Message : " + consumerRecord.value());
        Event event = Event.builder().id(UUID.randomUUID().toString()).
                key(consumerRecord.key().toString()).payload(consumerRecord.value()).timestamp(LocalDateTime.now().toString()).build();
        eventRepository.save(event).subscribe();
        ack.acknowledge();
    }
}
