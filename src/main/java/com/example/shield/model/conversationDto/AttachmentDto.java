package com.example.shield.model.conversationDto;

import lombok.Data;

@Data
public class AttachmentDto {

    private User user;

    private String dateTime;

    private String dateTimeUTC;

    private String conversationId;

    private String fileName;

    private String fileId;

    private String fileSize;
}