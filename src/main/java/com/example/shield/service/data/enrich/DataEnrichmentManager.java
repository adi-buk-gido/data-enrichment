package com.example.shield.service.data.enrich;

import java.util.List;

import org.springframework.stereotype.Component;

import com.example.shield.model.conversation.RoomConversation;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class DataEnrichmentManager {

    List<IDataEnrichmentService> dataEnrichmentServices;

    public void enrichData(RoomConversation roomConversation){
       for (IDataEnrichmentService iDataEnrichmentService : dataEnrichmentServices) {
        log.debug("enrich data from service: {}", iDataEnrichmentService);
            iDataEnrichmentService.enrich(roomConversation);
       }
        
        
    }

    
}
