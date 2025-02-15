package com.example.shield.service.data.enrich;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.shield.model.conversationDto.Conversation;
import com.example.shield.model.conversationDto.Participant;
import com.example.shield.model.conversationDto.RoomConversation;

@Service
public class CompanyDataEnrichmentService implements IDataEnrichmentService{


    @Override
    public void enrich(RoomConversation roomConversation) {
        List<Conversation> conversations = roomConversation.getConversations();
        for (Conversation conversation : conversations) {
            List<Participant> participantsEntered = conversation.getParticipantsEntered();
            for (Participant participantEntered : participantsEntered) {
                // TODO add rest impl
                
            }
        }
    }



}
