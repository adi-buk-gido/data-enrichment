package com.example.shield.service.data.enrich;


import com.example.shield.model.conversation.RoomConversation;

public interface IDataEnrichmentService  {

    
    /**
     * Enrich data
     */
    public void enrich(RoomConversation roomConversation);

}
