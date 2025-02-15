package com.example.shield.service.kafka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.example.shield.model.conversation.RoomConversation;
import com.example.shield.service.data.enrich.DataEnrichmentManager;

@Service
public class KafkaConsumerService {

    @Autowired
    DataEnrichmentManager dataEnrichmentManager;

    @KafkaListener(topics = "data-enrichment-topic", groupId = "enrichment-group")
    public void processData(RoomConversation data) {
        System.out.println("Received data for enrichment: " + data);
        dataEnrichmentManager.enrichData(data);
    }
}
