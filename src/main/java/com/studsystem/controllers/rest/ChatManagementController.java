package com.studsystem.controllers.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController()
public class ChatManagementController {

    @PutMapping("/chats/create-chat")
    public ResponseEntity putChat(@RequestParam String studentsUserId,
                                  @RequestParam String professorsUserId) {
        return ResponseEntity.status(HttpStatus.FORBIDDEN).body("Not yet implemented");
    }

    @GetMapping("/chats/get-chat")
    public ResponseEntity getChatOf(@RequestParam String studentsUserId,
                                    @RequestParam String professorsUserId) {
        return ResponseEntity.status(HttpStatus.FORBIDDEN).body("Not yet implemented");
    }

    @GetMapping("/chats/get-messages")
    public ResponseEntity getAllMessagesOfChat(@RequestParam String chatId) {
        return ResponseEntity.status(HttpStatus.FORBIDDEN).body("Not yet implemented");
    }

    @GetMapping("/chats/get-messages-of-time-range")
    public ResponseEntity getAllMessagesOfChat(@RequestParam String chatId,
                                               @RequestParam String beginTimestamp,
                                               @RequestParam String endTimestamp) {
        return ResponseEntity.status(HttpStatus.FORBIDDEN).body("Not yet implemented");
    }

}
