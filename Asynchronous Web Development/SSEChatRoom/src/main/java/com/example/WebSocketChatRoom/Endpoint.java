package com.example.WebSocketChatRoom;

import com.google.gson.Gson;
import jakarta.mail.MessageAware;
import jakarta.websocket.*;
import jakarta.websocket.server.PathParam;
import jakarta.websocket.server.ServerEndpoint;

import java.io.IOException;
import java.util.*;

@ServerEndpoint("/chat")
public class Endpoint {
    private final static Set<Session> sessions = new HashSet<>();
    private final static ArrayList<User> users = new ArrayList<>();
    private final static ArrayList<Message> messages = new ArrayList<>();

    @OnOpen
    public void onOpen(Session session) {
        sessions.add(session);
        System.out.println(users.size());

        User user = getUserFromSession(session);
        users.add(user);
        Gson gson = new Gson();
        String usersObj = gson.toJson(users);

        System.out.println(usersObj);
        for (Session curSession:
             sessions) {
            try {
                curSession.getBasicRemote().sendText(usersObj);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        String messagesObj = gson.toJson(messages);
        System.out.println(messagesObj);
        try {
            session.getBasicRemote().sendText(messagesObj);
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    private User getUserFromSession(Session session) {
        String[] queryStrings = session.getQueryString().split("&");
        System.out.println(session.getQueryString());
        User user = new User(queryStrings[0].split("=")[1], queryStrings[1].split("=")[1]);
        return user;
    }


    @OnMessage
    public void onMessage(String message, Session session) {
        User user = getUserFromSession(session);
        Message message1 = new Message(message, user, new Date().toString());
        messages.add(message1);
        broadcastMessage(message1);
    }

    private void broadcastMessage(Message message) {
        for (Session session:
                sessions) {

            Gson gson = new Gson();
            String msgObj = gson.toJson(message);
            System.out.println(msgObj);
            try {
                session.getBasicRemote().sendText(msgObj);
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }

    @OnClose
    public void onClose(Session session) {
        sessions.removeIf(curSession -> curSession.getId().equals(session.getId()));
        users.removeIf(user -> user.name.equals(session.getQueryString().split("&")[0].split("=")[1]));
        for (Session curSession: sessions) {
            Gson gson = new Gson();
            String usersObj = gson.toJson(users);
            System.out.println("ppppp"+usersObj);
            try {
                curSession.getBasicRemote().sendText(usersObj);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
