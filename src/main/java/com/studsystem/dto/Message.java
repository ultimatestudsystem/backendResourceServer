package com.studsystem.dto;

import com.studsystem.helper.DTO;
import com.studsystem.helper.DTOUtilities;
import com.studsystem.lambda.OnValidationFailure;
import com.studsystem.lambda.OnValidationSuccess;
import com.studsystem.interfaces.validation.MessagesValidationService;

public class Message extends DTO {

    public static Message getInstance() {
        return new Message();
    }

    private String key;
    private String chatKey;
    private String content;

    private MessagesValidationService messagesValidationService;

    private Message() {
        messagesValidationService = DTOUtilities.getValidationServiceOf(MessagesValidationService.class);
    }

    public String getKey() {
        return key;
    }

    public String getChatKey() {
        return chatKey;
    }

    public String getContent() {
        return content;
    }

    public Message setKey(String key, OnValidationSuccess lambdaSuccess, OnValidationFailure lambdaFailure) {
        this.key = key;
        onValid(messagesValidationService.isIsMessageKeyExists(getKey(), getChatKey()), lambdaSuccess, lambdaFailure);
        return this;
    }

    public Message setChatKey(String chatKey, OnValidationSuccess lambdaSuccess, OnValidationFailure lambdaFailure) {
        this.chatKey = chatKey;
        validateKey(messagesValidationService, getChatKey(), "chats", lambdaSuccess, lambdaFailure);
        return this;
    }

    public Message setContent(String content, OnValidationSuccess lambdaSuccess, OnValidationFailure lambdaFailure) {
        this.content = content;
        onValid(messagesValidationService.isContentValid(getContent()), lambdaSuccess, lambdaFailure);
        return this;
    }
}
