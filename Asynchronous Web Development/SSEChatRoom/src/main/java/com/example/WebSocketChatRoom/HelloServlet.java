package com.example.WebSocketChatRoom;

import java.io.*;
import java.util.ArrayList;
import java.util.Date;

import com.google.gson.Gson;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "helloServlet", value = "/chatServlet")
public class HelloServlet extends HttpServlet {
    private String message;
    private static final ArrayList<User> users = new ArrayList<>();
    private static final ArrayList<Message> messages = new ArrayList<>();

    public void init() {
        message = "Hello World!";
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

        response.setContentType("text/event-stream");
        response.setCharacterEncoding("UTF-8");

        PrintWriter out = response.getWriter();
        String lastId = request.getHeader("Last-Event-ID");
        Gson gson = new Gson();
        int msgId = 0;
        if (lastId != null) {
            msgId = Integer.parseInt(lastId);
            String data = "";
            if (msgId >= 0) {

                for (int i = msgId; i < messages.size(); i++) {
                    out.write("event: messageReceived\n");
                    out.write("data: " + gson.toJson(messages.get(i)) + "\n");
                    out.flush();
                }
                msgId=messages.size();
                out.write("id: " + msgId + "\n\n");
                out.flush();
            }
        } else {
            String name = request.getParameter("name");
            String gender = request.getParameter("gender");
            User user = new User(name, gender);
            users.add(user);
            System.out.println(users.size());
            System.out.println("helooo");
            msgId=messages.size();
            out.write("id: " + msgId + "\n");
            String msgsObj = gson.toJson(messages);
            out.write("event: allMessages\n");
            out.write("data: " + msgsObj + "\n\n");
            out.flush();
        }
        String usersObj = gson.toJson(users);
        out.write("event: allUsers\n");
        out.write("data: " + usersObj + "\n\n");
        out.flush();
        out.close();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        System.out.println("received message....");
        String message = request.getParameter("message");
        String senderName = request.getParameter("senderName");
        String senderGender = request.getParameter("senderGender");
        System.out.println(message+" "+senderGender+" "+senderName+"jjjjj");
        if(message.equals("CLOSECONNECTION")){
            users.removeIf(user -> user.getName().equals(senderName) && user.gender.equals(senderGender));
        }
        else {
            Message message1 = new Message(message, new User(senderName, senderGender), new Date().toString());
            messages.add(message1);
        }
    }

    public void destroy() {
    }
}