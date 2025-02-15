package com.example.shield.model.conversation;

import java.util.UUID;

import lombok.Data;

@Data
public class User {

    private String loginName;

    private String firstName;

    private String lastName;

    private String uuid;

    private String firmNumber;
    private String accountNumber;

    private String companyName;

    private String emailAddress;

    private String corporateEmailAddress;

    private UUID companyId;
}
