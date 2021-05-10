package com.example.WebSocketChatRoom;

public class Message {
    String message;
    User sender;
    String date;

    public Message(String message, User sender, String date) {
        this.message = message;
        this.sender = sender;
        this.date = date;
    }
}
