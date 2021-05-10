/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.ajaxlab2;

/**
 *
 * @author Hadeer
 */
class Message {
    private String name;
    private String message;

    public Message() {
    }

    public String getName() {
        return name;
    }

    public Message(String name, String message) {
        this.name = name;
        this.message = message;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
    
    
}
