package com.example.shield.model.conversationDto;

import lombok.Data;
import java.util.List;

@Data
public class RoomConversation {

    private List<Conversation> conversations;
}
