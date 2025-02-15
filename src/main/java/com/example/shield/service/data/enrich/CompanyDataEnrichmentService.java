package com.example.shield.service.data.enrich;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.shield.dao.CompanyDao;
import com.example.shield.model.conversation.Conversation;
import com.example.shield.model.conversation.Participant;
import com.example.shield.model.conversation.RoomConversation;

@Service
public class CompanyDataEnrichmentService implements IDataEnrichmentService{

    @Autowired
    CompanyDao companyDao;


    @Override
    public void enrich(RoomConversation roomConversation) {
        List<Conversation> conversations = roomConversation.getConversations();
        for (Conversation conversation : conversations) {
            List<Participant> participantsEntered = conversation.getParticipantsEntered();
            for (Participant participantEntered : participantsEntered) {
                //Assume I am getting company ID from 
                String companyName = participantEntered.getUser().getCompanyName();
                if(companyName != null){
                    UUID companyId = companyDao.getCompanyId(companyName);
                    participantEntered.getUser().setCompanyId(companyId);
                }
            }
        }
    }



}
