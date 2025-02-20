package com.example.shield.model.conversation;


import lombok.Data;

@Data
public class Attachment {

    private User user;

    private String dateTime;

    private String dateTimeUTC;

    private String conversationId;

    private String fileName;

    private String fileId;

    private String fileSize;
}