package com.example.shield.service.data.enrich;

import com.example.shield.dao.CompanyDao;
import com.example.shield.model.conversation.Conversation;
import com.example.shield.model.conversation.Participant;
import com.example.shield.model.conversation.RoomConversation;
import com.example.shield.model.conversation.User;

import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.UUID;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;
import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class CompanyDataEnrichmentServiceTest {

    @InjectMocks
    private CompanyDataEnrichmentService companyDataEnrichmentService;

    @Mock
    private CompanyDao companyDao;

    @Before
    public void setUp() {
        MockitoAnnotations.openMocks(this); 
    }

    @Test
    public void testEnrich_ShouldSetCompanyId_WhenCompanyNameExists() {
        // Given
        RoomConversation roomConversation = new RoomConversation();
        Conversation conversation = new Conversation();
        Participant participant = new Participant();
        User user = new User();
        user.setCompanyName("TechCorp");
        participant.setUser(user);
        conversation.setParticipantsEntered(Arrays.asList(participant));
        roomConversation.setConversations(Arrays.asList(conversation));

        UUID mockCompanyId = UUID.randomUUID();
        when(companyDao.getCompanyId("TechCorp")).thenReturn(mockCompanyId);

        // When
        companyDataEnrichmentService.enrich(roomConversation);

        // Then
        assertEquals(mockCompanyId, user.getCompanyId()); // ✅ Ensure company ID is set
        verify(companyDao, times(1)).getCompanyId("TechCorp"); // ✅ Ensure DAO was called
    }

    @Test
    public void testEnrich_ShouldNotSetCompanyId_WhenCompanyNameIsNull() {
        // Given
        RoomConversation roomConversation = new RoomConversation();
        Conversation conversation = new Conversation();
        Participant participant = new Participant();
        User user = new User();
        user.setCompanyName(null);
        participant.setUser(user);
        conversation.setParticipantsEntered(Arrays.asList(participant));
        roomConversation.setConversations(Arrays.asList(conversation));

        // When
        companyDataEnrichmentService.enrich(roomConversation);

        // Then
        assertNull(user.getCompanyId()); // ✅ Ensure company ID is still null
        verify(companyDao, never()).getCompanyId(anyString()); // ✅ Ensure DAO was not called
    }
}
